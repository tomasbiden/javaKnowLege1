package org.mutiThred.Leecode.L117produceH20.myself;

import java.util.concurrent.atomic.AtomicInteger;

public class my1 {
//    注意这个题目其实他是会调用3个线程的，而不是调用两个线程
    AtomicInteger size2=new AtomicInteger(2);
    int size=2;
    public my1() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        while (size2.get()==0){
            Thread.yield();

        }

        releaseHydrogen.run();
        size2.decrementAndGet();
    }
//     oxygen

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
       while (size2.get()>0){
           Thread.yield();

       }
       releaseOxygen.run();

       size2.getAndAdd(2);

    }

    public static void main(String [] args) throws InterruptedException {
        my1 my1 = new my1();

        Thread thred1 = new Thread(() -> {
            try {
                my1.hydrogen(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("H");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread thred2 = new Thread(() -> {
            try {
                my1.oxygen(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("O");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


        Thread thred3 = new Thread(() -> {
            try {
                my1.hydrogen(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("H");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        thred2.start();
        thred1.start();
        thred3.start();

//        thred3.getState()

        Thread.sleep(4000);


    }

}
