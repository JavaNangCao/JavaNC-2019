package com.company;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "- Value i = " + i);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
