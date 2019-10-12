package com.example.designmode.strategymode.controller;

import com.example.designmode.strategymode.model.DemoPojo;
import com.example.designmode.strategymode.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyController {

    @Autowired(required = true)
    StrategyService strategyService;

    @PostMapping("/choose")
    @ResponseBody
//    public String choose(@RequestBody DemoPojo demoPojo) {
    public String choose(DemoPojo demoPojo, String param) {
//        return strategyService.getResource(demoPojo);
        System.out.println("param name: " + demoPojo.getName());
        return demoPojo.getName();
    }
}
