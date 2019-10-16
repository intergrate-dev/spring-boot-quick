package com.example.designmode.factorymode.factorymethod.other;

import com.example.designmode.factorymode.factorymethod.Handler.IOHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用简单工厂模式实现
 */
public class IOSimpleFactory {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static IOHandler getHandler(Class<? extends IOHandler> clz) {
        IOHandler handler = null;
        try {
            handler = (IOHandler) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handler;
    }
}
