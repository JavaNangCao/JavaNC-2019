package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        /*
        //System.out.println("Thread name: " + Thread.currentThread().getName());
        SimpleThread thread1 = new SimpleThread();
        thread1.setName("Thread-1");
        //thread1.setPriority();
        thread1.start();
        SimpleThread thread2 = new SimpleThread();
        thread2.setName("Thread-2");
        thread2.start();

        Thread thread3 = new Thread(new RunnableThread());
        thread3.setName("Thread-3");
        thread3.start();

         */
        String filename = "D:\\ListUser.json";
        ThreadReader reader = new ThreadReader("");
        reader.setFilename(filename);

//        while (reader.getFilename().isEmpty()){
//            Thread.sleep(50);
//        }
        complectionListener complectionListener = new complectionListener() {
            @Override
            public void onComplete() {
                System.out.println("Text: " + reader.getFilecontex().toString());
            }
        };
        reader.setComplectionListener(complectionListener);
        reader.read();
        System.out.println(reader.getFilecontex());
    }
}

interface complectionListener {
    void onComplete();
}

