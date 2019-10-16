package com.example.designmode.singletonmode;

/**
 * 静态内部类的单例模式（线程安全，有懒加载）
 * 特点：懒加载的同时保证线程安全，推荐使用
 * 解析：为什么会线程安全？类的构造器<clinit>()方法在多线程环境中被正确地加载，同步，如果多个线程同时去初始化一个类，那么只有一个线程去执行这个类的，
 * 其他线程都需要阻塞等待，直到活动线程执行<clinit>（）方法完毕。
 */
public class Singleton {
    private Singleton(){}

    public static Singleton newInstance(){
        return SingletonHolder.instance;
    }

    //内部类，在装载该内部类时才会去创建单例对象
    private static class SingletonHolder{
        public static Singleton instance = new Singleton();
    }

}
