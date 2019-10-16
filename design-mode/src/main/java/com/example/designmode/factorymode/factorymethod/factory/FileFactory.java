package com.example.designmode.factorymode.factorymethod.factory;

import com.example.designmode.factorymode.factorymethod.Handler.FileHandler;
import com.example.designmode.factorymode.factorymethod.Handler.IOHandler;

public class FileFactory extends IOFactory{
    @Override
    public IOHandler getHandler() {
        return new FileHandler();
    }
}
