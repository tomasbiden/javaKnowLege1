package org.mutiThred.Leecode.L1115PrintFooBar.myself;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


//刚才不应该在错误代码直接修改的，应该是先复杂再修改
class my2 {
    private int n;
    static SimpleDateFormat sdf = new SimpleDateFormat("sss");

    AtomicInteger atomicInteger=new AtomicInteger(0);

    public my2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(!atomicInteger.compareAndSet(0,1)){
//                Thread.yield();
                System.out.println("foo等待中，为1");

            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
//            System.out.println("foo"+atomicInteger.get());

            printFoo.run();



//            atomicInteger.incrementAndGet();
//            Thread.sleep(200);

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(!atomicInteger.compareAndSet(atomicInteger.get(),0)){
//                Thread.yield();
                System.out.println("bar等待中，为0");
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
//            System.out.println("bar"+atomicInteger.get());

//            atomicInteger.decrementAndGet();
//            Thread.sleep(100);
            printBar.run();

        }
    }

    public static void main(String [] args) throws InterruptedException {
        my2 my1 = new my2(8);
        Thread f00 = new Thread(() -> {
            try {
                my1.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("0f"+" "+sdf.format(new Date())) ;
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
                        System.out.println("1b"+" "+sdf.format(new Date()));
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