package com.jyj.concurrency.example.singleton;

import com.jyj.concurrency.annoations.NotRecommend;
import com.jyj.concurrency.annoations.ThreadSafe;

/**
 * @Description: 懒汉模式 单例的实例在第一次使用时进行创建
 * @Date: 2018/12/19 14:32
 * @Author:jyj
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有的构造函数
    private SingletonExample3() {

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
