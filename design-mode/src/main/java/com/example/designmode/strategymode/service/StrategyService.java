package com.example.designmode.strategymode.service;

import com.example.designmode.strategymode.model.DemoPojo;
import com.example.designmode.strategymode.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service(value = "strategyService")
public class StrategyService {
    @Autowired(required = true)
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    public StrategyService(Map<String, Strategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

    public String getResource(DemoPojo demoPojo){
        if (!strategyMap.containsKey(demoPojo.getPoolId())) {
            return "couldn't match any service";
        }
        return strategyMap.get(demoPojo.getPoolId()).getVpcList(demoPojo);
    }

}
