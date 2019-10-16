package com.example.designmode.factorymode.simplefactory.factory;

import com.example.designmode.factorymode.simplefactory.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HandlerFactory {
    @Autowired
    private Map<String , Handler> handlerMap;

    public Handler getHandlerByName(String name){
        return handlerMap.get(name);
    }

}
