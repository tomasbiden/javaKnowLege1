package org.mutiThred.Leecode.L1115PrintFooBar.myself;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

//刚才不应该在错误代码直接修改的，应该是先复杂再修改
class my3_volatile {
    private int n;
    volatile  int vi=0;
    AtomicInteger atomicInteger=new AtomicInteger(0);

    static SimpleDateFormat sdf = new SimpleDateFormat("ss:SSS");

    public my3_volatile(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(vi==1){
                Thread.yield();
//                System.out.println("foo等待中，为1");

            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
//            System.out.println("foo"+atomicInteger.get());

            printFoo.run();
            vi=1;


//            atomicInteger.incrementAndGet();
//            Thread.sleep(200);

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

//            注意这里是0 而不是1
            while(vi==0){
                Thread.yield();
//                System.out.println("bar等待中，为0");
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
//            System.out.println("bar"+atomicInteger.get());

//            atomicInteger.decrementAndGet();
//            Thread.sleep(100);
            printBar.run();
            vi=0;
        }
    }

    public static void main(String [] args) throws InterruptedException {
        my3_volatile my1 = new my3_volatile(10);
        Thread f00 = new Thread(() -> {
            try {
                my1.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread bar = new Thread(() -> {
            try {
                my1.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bar");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Date date = new Date();


        f00.start();
        bar.start();


        f00.join();
        bar.join();
        System.out.println(sdf.format(new Date().getTime()-date.getTime()));

    }
}