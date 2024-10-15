package org.mutiThred.Leecode.L1115PrintFooBar.myself;

import java.util.concurrent.atomic.AtomicInteger;

//刚才不应该在错误代码直接修改的，应该是先复杂再修改
class m1_actomicInteger {
    private int n;

    AtomicInteger atomicInteger=new AtomicInteger(0);

    public m1_actomicInteger(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(atomicInteger.get()==1){
//                System.out.println("foo等待中，为1");
                Thread.yield();

            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
//            System.out.println("foo"+atomicInteger.get());

            printFoo.run();
            atomicInteger.incrementAndGet();


//            atomicInteger.incrementAndGet();
//            Thread.sleep(200);

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

//            注意这里是0 而不是1
            while(atomicInteger.get()==0){
//                System.out.println("bar等待中，为0");
                Thread.yield();
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
//            System.out.println("bar"+atomicInteger.get());

//            atomicInteger.decrementAndGet();
//            Thread.sleep(100);
            printBar.run();
            atomicInteger.decrementAndGet();
        }
    }

    public static void main(String [] args) throws InterruptedException {
        m1_actomicInteger my1 = new m1_actomicInteger(13);
        Thread f00 = new Thread(() -> {
            try {
                my1.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("0f");
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
                        System.out.println("1b");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        f00.start();
        bar.start();
        Thread.sleep(5000);


    }
}