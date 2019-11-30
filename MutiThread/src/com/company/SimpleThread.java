package com.company;

public class SimpleThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " started");
        for(int i = 0; i < 10; i++){
            // tam dung 50msc.
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "- Value i = " + i);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}