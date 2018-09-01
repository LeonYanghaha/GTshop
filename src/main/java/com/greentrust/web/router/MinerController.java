package com.greentrust.web.router;

import com.greentrust.entity.Miner;
import com.greentrust.entity.Res;
import com.greentrust.service.MinerService;
import com.greentrust.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/miner")
public class MinerController {

    @Autowired
    MinerService minerService;

    @GetMapping(value = {"/getminer/{id}"})
    public Res getMinerById(@PathVariable("id") Integer id){

        return Util.getSuccessRes(minerService.getMinerById(id));

    }
    @GetMapping("/minerlist")
    public Res getMinerList(){
        List<Miner> minerList = minerService.getMinerList();
        if(minerList.size()>=1){
            return Util.getSuccessRes(minerList);
        }else{
            return Util.getErrorRes("none",null);
        }
    }

}
