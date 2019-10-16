package com.example.designmode.factorymode.abstractfactory.factory;

import com.example.designmode.factorymode.abstractfactory.service.DepartmentService;
import com.example.designmode.factorymode.abstractfactory.service.UserService;
import com.example.designmode.factorymode.abstractfactory.service.impl.MysqlDepartmentServiceImpl;
import com.example.designmode.factorymode.abstractfactory.service.impl.MysqlUserServiceImpl;

public class MysqlFactory implements IDBFactory {
    @Override
    public UserService createUser() {
        return new MysqlUserServiceImpl();
    }

    @Override
    public DepartmentService createDepartment() {
        return new MysqlDepartmentServiceImpl();
    }
}
