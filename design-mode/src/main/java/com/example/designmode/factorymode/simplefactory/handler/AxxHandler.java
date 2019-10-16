package com.example.designmode.factorymode.simplefactory.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("axxHandler")
public class AxxHandler implements Handler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void print() {
        logger.info("axxHandler print ...");
    }
}
