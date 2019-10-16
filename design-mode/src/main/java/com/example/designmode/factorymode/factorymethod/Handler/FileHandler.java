package com.example.designmode.factorymode.factorymethod.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler extends IOHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void add(String key, String value) {
        logger.info("FileHanlder:添加一条记录");
    }

    @Override
    public void remove(String key) {
        logger.info("FileHanlder:删除一条记录");
    }

    @Override
    public void update(String key, String value) {
        logger.info("FileHanlder:更新一条记录");
    }

    @Override
    public void query(String key) {
        logger.info("FileHanlder:查询一条记录");
    }
}
