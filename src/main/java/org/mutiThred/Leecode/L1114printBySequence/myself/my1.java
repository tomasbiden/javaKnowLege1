package org.mutiThred.Leecode.L1114printBySequence.myself;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

class my1 {
    static Object lock=new Object();

    static  int flag=1;
    volatile int  index=1;

    AtomicInteger atomicInteger=new AtomicInteger(1);

    public my1() {

    }
    Runnable printFirst1=new Runnable() {
        @Override
        public  void run() {
            System.out.println("1");
            index++;
            atomicInteger.decrementAndGet();



        }
    };

    Runnable printFirst=new Runnable() {
        @Override
        public  void run() {
            System.out.println("1");



        }
    };

    Runnable printSecond2=new Runnable() {
        @Override
        public  void run() {
//            用 if就大错特错了啊
            while (index!=2){


            }


            System.out.println("2");
            index++;



        }
    };
    Runnable printSecond=new Runnable() {

        @Override
        public   void run() {


            System.out.println("2");


        }
    };

    Runnable printThird2=new Runnable() {
        @Override
        public   void run() {

            while (index!=3){

            }

            System.out.println("3");


        }
    };

    Runnable printThird=new Runnable() {
        @Override
        public   void run() {


            System.out.println("3");


        }
    };



    public  void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            printFirst.run();
            flag++;
            lock.notifyAll();

        }

        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public   void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){

            while (flag!=2){
                lock.wait();
            }
            printSecond.run();
            flag++;
            lock.notify();

        }


    }

    public   void third(Runnable printThird) throws InterruptedException {

        synchronized (lock){

            while (flag!=3){
                lock.wait();
            }
            printThird.run();



        }
    }

    public static void main(String[] args) throws InterruptedException {
        my1 object1 = new my1();
        Thread thread1 = new Thread(()->{
            try {
                object1.first(object1.printFirst);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"1thred");
        Thread thread2 = new Thread(() -> {
            try {
                object1.second(object1.printSecond);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"2thred");

        Thread thread3= new Thread(() -> {
            try {
                object1.third(object1.printThird);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"3thred");
//        thread3.start();

        thread1.start();
        thread3.start();
        thread2.start();


        ReentrantLock reentrantLock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(2);

//         new Semaphore()
//        Synchronized
//        AbstractQueuedSynchronizer

//        new Thread()


        Thread.sleep(1000);

    }
}
