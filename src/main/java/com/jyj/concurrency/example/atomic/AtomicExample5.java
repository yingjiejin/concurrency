package com.jyj.concurrency.example.atomic;

import com.jyj.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description:
 * @Date: 2018/12/18 14:34
 * @Author:jyj
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    private volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("updater success 1 ,{}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("updater success 2  ,{}", example5.getCount());
        } else {
            log.info("updater failed,{}", example5.getCount());
        }
    }
}
