package com.example.designmode.factorymode.abstractfactory.service.impl;

import com.example.designmode.factorymode.abstractfactory.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service
public class OricleDepartmentServiceImpl implements DepartmentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void setDepartment(int id, String name) {
        //将id、name插入Department表
        System.out.println("在Oricle中增加一条department记录：");
    }

    @Override
    public String getDepartmentName(int id) {
        //获取id位置的name值
        System.out.println("在Oricle中获得一条department记录：");
        return null;
    }
}
