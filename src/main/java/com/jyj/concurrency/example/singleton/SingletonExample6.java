package com.jyj.concurrency.example.singleton;

import com.jyj.concurrency.annoations.ThreadSafe;

/**
 * @Description: 饿汉模式 单例的实例在类装载时进行创建
 * @Date: 2018/12/19 14:32
 * @Author:jyj
 */
@ThreadSafe
public class SingletonExample6 {

    //私有的构造函数
    private SingletonExample6() {

    }

    //单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }


    //静态工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
