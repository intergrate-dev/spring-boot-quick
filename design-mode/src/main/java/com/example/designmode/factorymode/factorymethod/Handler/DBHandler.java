package com.example.designmode.factorymode.factorymethod.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBHandler extends IOHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void add(String key, String value) {
        System.out.println("DBHandler:添加一条记录");
    }

    @Override
    public void remove(String key) {
        System.out.println("DBHandler:删除一条记录");
    }

    @Override
    public void update(String key, String value) {
        System.out.println("DBHandler:更新一条记录");
    }

    @Override
    public void query(String key) {
        System.out.println("DBHandler:查询一条记录");
    }
}
