package com.example.designmode.factorymode.factorymethod.factory;

import com.example.designmode.factorymode.factorymethod.Handler.IOHandler;
import com.example.designmode.factorymode.factorymethod.Handler.XmlHandler;

public class XmlFactory extends IOFactory {

    @Override
    public IOHandler getHandler() {
        return new XmlHandler();
    }
}
