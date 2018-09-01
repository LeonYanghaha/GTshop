package com.greentrust.service;

import com.greentrust.entity.Miner;
import java.util.List;

public interface MinerService {

    public List<Miner> getMinerList();

    public Miner getMinerById(Integer id);

}
