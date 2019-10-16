package com.example.designmode.singletonmode;

public class LazyLoadSingleton {
    private static volatile LazyLoadSingleton instance = null;
    private LazyLoadSingleton(){}

    public static LazyLoadSingleton getInstance() {
        if (instance == null) {  //此处避免了不必要的同步
            synchronized (LazyLoadSingleton.class) {
                if (instance == null) {
                    instance = new LazyLoadSingleton();
//                    new LazyLoadSingleton() 做了3件事情：
//                    (1)、给Singleton的实例分配内存
//                    (2)、调用Singleton()的构造函数
//                    (3)、将instance对象指向分配的内存空间
                }
            }
        }

        return instance;
    }
}
