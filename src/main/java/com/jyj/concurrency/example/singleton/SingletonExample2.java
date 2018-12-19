package com.jyj.concurrency.example.singleton;

import com.jyj.concurrency.annoations.ThreadSafe;

/**
 * @Description: 饿汉模式 单例的实例在类装载时进行创建
 * @Date: 2018/12/19 14:32
 * @Author:jyj
 */
@ThreadSafe
public class SingletonExample2 {

    //私有的构造函数
    private SingletonExample2() {

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
