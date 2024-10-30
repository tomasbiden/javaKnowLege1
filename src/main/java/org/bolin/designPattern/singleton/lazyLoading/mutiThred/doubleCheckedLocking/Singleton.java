package org.bolin.designPattern.singleton.lazyLoading.mutiThred.doubleCheckedLocking;

public class Singleton {
    private  static  volatile  Singleton instance;
    public  Singleton(){

    }
    private static Singleton getInstance(){
        if(instance!=null){
            return  instance;
        }else {

            synchronized (Singleton.class){
                if(instance!=null){
                    return instance;
                }else {
                    instance=new Singleton();
                    return  instance;
                }
            }
        }

    }


    private static Singleton getInstance2(){
        if(instance==null){
            synchronized (Singleton.class){
                instance=new Singleton();
            }
        }
        return  instance;

    }
}
