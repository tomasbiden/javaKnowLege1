package org.bolin.mutiThred.Leecode.L1115PrintFooBar.myself;

import java.util.concurrent.atomic.AtomicInteger;


class foutrh {
    private static volatile int n=0;
    private  int num=0;

    AtomicInteger atomicInteger=new AtomicInteger(0);

    public foutrh(int num) {
        this.num = num;
    }

    public void t1(Runnable printFoo) throws InterruptedException {

        while (n<=num){
            while(atomicInteger.get()==1){

                Thread.yield();

            }

            if(n<=num){
                printFoo.run();
                atomicInteger.incrementAndGet();
            }


        }




    }

    public void t2(Runnable printBar) throws InterruptedException {


           while (n<=num){

               while(atomicInteger.get()==0&&n<=num){
                   Thread.yield();
               }

               if(n<=num){
                   printBar.run();
                   atomicInteger.decrementAndGet();
               }


           }


    }

    public static void main(String [] args) throws InterruptedException {
        foutrh my1 = new foutrh(200);
        Thread thread1 = new Thread(() -> {
            try {
                my1.t1(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(n++);
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2= new Thread(() -> {
            try {
                my1.t2(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(n++);
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        thread1.start();
        thread2.start();
        Thread.sleep(1000);


    }
}