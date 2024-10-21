package org.bolin.javaBasic.preSave.tThread;

public class first {
    public  class tnewThread extends Thread{
        public  void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2sdfsdf");
        }
    }

    public  static void main(String[] args){

//        tnewThread tnewThread = new tnewThread();  错误代码，反思
        first first = new first();
        tnewThread tnewThread = first.new tnewThread();
        tnewThread.start();


        Thread sdfsdf = new Thread(()->{
            System.out.println("sdfsdf");
        });
        sdfsdf.start();
    }
}
