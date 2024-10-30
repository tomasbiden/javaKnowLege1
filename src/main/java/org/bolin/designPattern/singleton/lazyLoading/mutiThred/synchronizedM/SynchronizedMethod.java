package org.bolin.designPattern.singleton.lazyLoading.mutiThred.synchronizedM;

public class SynchronizedMethod {
    private static   SynchronizedMethod instance;
    private  synchronized  static SynchronizedMethod getInstance(){
        if(instance==null){
            instance=new SynchronizedMethod();
        }

        return  instance;

    }
}
