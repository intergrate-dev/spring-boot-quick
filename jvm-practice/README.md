
### 内存泄漏
内存泄露根本原因：
长生命周期的对象持有短生命周期对象的引用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不能被回收。
https://www.ibm.com/developerworks/cn/java/l-JavaMemoryLeak/
https://www.cnblogs.com/woaiadu/p/7169220.html
常见情况：
https://www.jdon.com/50632
https://www.jb51.net/article/154599.htm

实例：
https://www.cnblogs.com/invinboy/p/10842406.html
https://blog.csdn.net/qq_27376871/article/details/78492908
https://blog.csdn.net/m0_38110132/article/details/81986334
https://www.jianshu.com/p/c8f4e0e8270e
https://blog.51cto.com/12142907/2343854


单例模式引起的内存泄漏，解决方法：
1.静态对象的生命周期与应用程序的生命周期一致
2.持有传入的context的弱引用
见 https://blog.51cto.com/whatever957/1834138

