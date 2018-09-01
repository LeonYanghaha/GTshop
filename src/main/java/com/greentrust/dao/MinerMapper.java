package com.greentrust.dao;

import com.greentrust.entity.Miner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MinerMapper {


    @Select("SELECT id,NAME,TYPE,price,stock FROM miner")
    List<Miner> getMinerList();

    @Select("SELECT id,NAME,TYPE,price,stock FROM miner WHERE id=#{id}")
    Miner getMinerById(@Param("id") Integer id);


}
