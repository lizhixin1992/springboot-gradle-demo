package com.example.demo;

import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName
 * @Description TODO
 * @Date 2019-03-03 16:10
 **/
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    for (int i = 0; i < 5; i++) {
                        queue.put(i);
                    }
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("take from putThread: " + queue.take());
                    }
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }
}