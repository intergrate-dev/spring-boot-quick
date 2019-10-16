package com.example.designmode.factorymode.factorymethod.factory;

import com.example.designmode.factorymode.factorymethod.Handler.IOHandler;

public abstract class IOFactory {
    public abstract IOHandler getHandler();
}
