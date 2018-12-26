package com.jyj.concurrency.example.threadLocal;

/**
 * @Description:
 * @Date: 2018/12/26 16:07
 * @Author:jyj
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
