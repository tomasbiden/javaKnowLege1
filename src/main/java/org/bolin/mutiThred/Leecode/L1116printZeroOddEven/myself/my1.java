package org.bolin.mutiThred.Leecode.L1116printZeroOddEven.myself;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class my1 {
    volatile boolean ji = true;

    volatile boolean zero = true;
    private int n;

    AtomicInteger n2 = new AtomicInteger(1);


    public my1(int n) {
        this.n = n;


    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
//        while n>0不能漏掉啊
        while (n2.get() <= n) {
            while (!zero) {
                Thread.yield();
            }
            if (n2.get() <= n) {
//                System.out.print("even" + " " + n2.get() + " " + n);
//                System.out.println();
                printNumber.accept(0);

            }

            zero = false;

        }


    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (n2.get() <= n) {
            while (zero || ji) {
                Thread.yield();
            }
            if (n2.get() <= n) {
//                System.out.print("even" + " " + n2.get() + " " + n);
//                System.out.println();
                printNumber.accept(n2.get());

            }


            n2.incrementAndGet();
            zero = true;
            ji = true;

        }


    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (n2.get() <= n) {
            while (zero || !ji) {
                Thread.yield();
            }
            if (n2.get() <= n) {
//                System.out.print("even" + " " + n2.get() + " " + n);
//                System.out.println();
                printNumber.accept(n2.get());

            }

            n2.incrementAndGet();
            zero = true;
            ji = false;

        }

    }


    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        while (n2.get() <= n) {
            while (zero) {
                Thread.yield();
            }
            printNumber.accept(n2.get());
            n2.incrementAndGet();
            zero = true;
//            ji=false;

        }

    }

    public static void main(String[] args) throws InterruptedException {
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };
        my1 my1 = new my1(8);
        Thread thread1 = new Thread(() -> {
            try {
                my1.zero(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread thread2 = new Thread(() -> {
            try {
                my1.even(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread thread3 = new Thread(() -> {
            try {
                my1.odd(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread thread4 = new Thread(() -> {
            try {
                my1.printOdd(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        thread1.start();
        thread2.start();
        thread3.start();
//        thread4.start();

        Thread.sleep(10000);


    }
}
