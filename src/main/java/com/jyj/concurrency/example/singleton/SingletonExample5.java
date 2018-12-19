package com.jyj.concurrency.example.singleton;

import com.jyj.concurrency.annoations.ThreadSafe;

/**
 * @Description: 懒汉模式 单例的实例在第一次使用时进行创建  双重同步锁单例模式
 * @Date: 2018/12/19 14:32
 * @Author:jyj
 */
@ThreadSafe
public class SingletonExample5 {

    //私有的构造函数
    private SingletonExample5() {

    }

    // 执行instance = new SingletonExample4();
    // 1.memory = allocate() 分配对象的内存空间
    // 2.ctorInstance() 初始化对象
    // 3.instance = memory 设置instance指向刚分配的内存

    //单例对象  volatile + 双重检测机制 --》 禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态工厂方法
    public static SingletonExample5 getInstance() {
        //双重检测机制
        if (instance == null) {
            //同步锁
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
