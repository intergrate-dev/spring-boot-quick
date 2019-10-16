package com.example.designmode.factorymode.abstractfactory.factory;

import com.example.designmode.factorymode.abstractfactory.service.DepartmentService;
import com.example.designmode.factorymode.abstractfactory.service.UserService;
import com.example.designmode.factorymode.abstractfactory.service.impl.OricleDepartmentServiceImpl;
import com.example.designmode.factorymode.abstractfactory.service.impl.OricleUserServiceImpl;

public class OricleFactory implements IDBFactory {
    @Override
    public UserService createUser() {
        return new OricleUserServiceImpl();
    }

    @Override
    public DepartmentService createDepartment() {
        return new OricleDepartmentServiceImpl();
    }
}
