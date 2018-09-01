package com.greentrust.service.impl;

import com.greentrust.dao.MinerMapper;
import com.greentrust.entity.Miner;
import com.greentrust.service.MinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MinerServiceImpl implements MinerService {

    @Autowired
    MinerMapper minerMapper;

    @Value("${redisCacheKey.minerList.minerKey}")
    String minerKey ;

    @Autowired
    @Resource
    private RedisTemplate<String, String> rt;

    @Override
    public List<Miner> getMinerList() {
        HashOperations<String,String,String> vo = rt.opsForHash();
        List<Miner> minerList = minerMapper.getMinerList();
        Map<String,String> minerHashMap= new HashMap();
        for(int i = 0 ; i < minerList.size() ; i++){
            Miner miner = minerList.get(i);
            minerHashMap.put(miner.getId()+"",miner.toString());
        }
        vo.putAll(minerKey, minerHashMap);
        return minerList;
    }

    @Override
    public Miner getMinerById(Integer id) {
        // 使用redis缓存数据。每次先去redis中拿数据，如果没有，再去mysql拿数据
        HashOperations<String,String,String> vo = rt.opsForHash();
        String str = vo.get(minerKey,id+"");
        Miner miner = Miner.fromJSON(str);
        if(miner ==null){
            miner = minerMapper.getMinerById(id);
        }
        return miner;
    }
}
