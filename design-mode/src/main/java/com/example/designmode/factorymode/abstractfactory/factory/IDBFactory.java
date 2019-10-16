package com.example.designmode.factorymode.abstractfactory.factory;

import com.example.designmode.factorymode.abstractfactory.service.DepartmentService;
import com.example.designmode.factorymode.abstractfactory.service.UserService;

public interface IDBFactory {
    public UserService createUser();
    public DepartmentService createDepartment();
}
