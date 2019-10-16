package com.example.designmode.factorymode.factorymethod.factory;

import com.example.designmode.factorymode.factorymethod.Handler.DBHandler;
import com.example.designmode.factorymode.factorymethod.Handler.IOHandler;

public class DBFactory extends IOFactory {
    @Override
    public IOHandler getHandler() {
        return new DBHandler();
    }
}
