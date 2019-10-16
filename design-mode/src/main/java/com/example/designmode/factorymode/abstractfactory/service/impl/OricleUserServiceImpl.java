package com.example.designmode.factorymode.abstractfactory.service.impl;

import com.example.designmode.factorymode.abstractfactory.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service
public class OricleUserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void setUser(int id, String name) {
        //将id、name插入数据库表
        System.out.println("在Oricle中增加一条user记录：");
    }

    @Override
    public String getUserName(int id) {
        //获取id位置的name值
        System.out.println("在Oricle中获得一条user记录：");
        return null;
    }
}
