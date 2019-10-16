package com.example.designmode.factorymode.factorymethod.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlHandler extends IOHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void add(String key, String value) {
        System.out.println("XMLHandler:添加一条记录");
    }

    @Override
    public void remove(String key) {
        System.out.println("XMLHandler:删除一条记录");
    }

    @Override
    public void update(String key, String value) {
        System.out.println("XMLHandler:更新一条记录");
    }

    @Override
    public void query(String key) {
        System.out.println("XMLHandler:查询一条记录");
    }
}
