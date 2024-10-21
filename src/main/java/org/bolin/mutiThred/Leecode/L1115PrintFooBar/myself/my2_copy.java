package org.bolin.mutiThred.Leecode.L1115PrintFooBar.myself;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


//刚才不应该在错误代码直接修改的，应该是先复杂再修改
class my2_copy {
    private int n;
    static SimpleDateFormat sdf = new SimpleDateFormat("sss");

    AtomicInteger atomicInteger=new AtomicInteger(0);

    public my2_copy(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(!atomicInteger.compareAndSet(0,1)){
//                Thread.yield();
//                System.out.println("foo等待中，为1");

            }


            // printFoo.run() outputs "foo". Do not change or remove this line.
//            System.out.println("foo"+atomicInteger.get());
            /*
            while (atomicInteger.compareAndSet(1,1)){
                Thread.yield();

            }

             */


            printFoo.run();
//            atomicInteger.compareAndSet(0,1);



//            atomicInteger.incrementAndGet();
//            Thread.sleep(200);

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(!atomicInteger.compareAndSet(0,1)){
//                Thread.yield();
//                System.out.println("bar等待中，为0");
            }


            /*
            while (atomicInteger.compareAndSet(0,0)){

                Thread.yield();

            }

             */

            // printBar.run() outputs "bar". Do not change or remove this line.
//            System.out.println("bar"+atomicInteger.get());

//            atomicInteger.decrementAndGet();
//            Thread.sleep(100);
            printBar.run();
//            atomicInteger.compareAndSet(1,0);

        }
    }

    public static void main(String [] args) throws InterruptedException {
        my2_copy my1 = new my2_copy(10);
        Thread f00 = new Thread(() -> {
            try {
                my1.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo"+" "+sdf.format(new Date())) ;
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"foofoo");

        Thread bar = new Thread(() -> {
            try {
                my1.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bar"+" "+sdf.format(new Date()));
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },"barbar");

        f00.start();
        bar.start();

        f00.join();
        bar.join();


    }
}