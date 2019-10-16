package com.example.designmode.factorymode.simplefactory.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("bxxHandler")
public class BxxHandler implements Handler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void print() {
        logger.info("bxxHandler print ...");
    }
}
