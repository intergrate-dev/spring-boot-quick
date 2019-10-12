package com.example.designmode.strategymode.strategy.impl;

import com.example.designmode.strategymode.model.DemoPojo;
import com.example.designmode.strategymode.strategy.Strategy;
import org.springframework.stereotype.Component;

@Component
public class BxxStrategy implements Strategy {
    @Override
    public String getVpcList(DemoPojo demoPojo) {
        System.out.println("Bxx, getVpcList ==========="+demoPojo);
        return demoPojo.getName();
    }
}
