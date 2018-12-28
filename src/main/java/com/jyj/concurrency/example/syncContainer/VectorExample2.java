package com.jyj.concurrency.example.syncContainer;

import com.jyj.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * @Description:
 * @Date: 2018/12/27 10:38
 * @Author:jyj
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}
