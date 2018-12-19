package com.jyj.concurrency.example.singleton;

import com.jyj.concurrency.annoations.Recommend;
import com.jyj.concurrency.annoations.ThreadSafe;

/**
 * @Description: 枚举模式：最安全
 * @Date: 2018/12/19 15:16
 * @Author:jyj
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    /**
     * 私有构造函数
     */
    private SingletonExample7() {
    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
