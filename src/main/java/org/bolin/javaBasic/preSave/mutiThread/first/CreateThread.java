package org.bolin.javaBasic.preSave.mutiThread.first;

public class CreateThread {
    public static  void main(String[] args){
        Thread sdf = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("sdf");
        });
        sdf.start();

    }
}
