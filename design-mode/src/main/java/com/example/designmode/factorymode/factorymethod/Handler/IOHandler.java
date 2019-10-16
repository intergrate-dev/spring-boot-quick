package com.example.designmode.factorymode.factorymethod.Handler;

public abstract class IOHandler {
    public abstract void add(String key,String value);
    public abstract void remove(String key);
    public abstract void update(String key,String value);
    public abstract void query(String key);
}
