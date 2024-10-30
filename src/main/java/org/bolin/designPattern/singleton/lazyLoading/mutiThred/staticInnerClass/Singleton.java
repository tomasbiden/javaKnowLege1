package org.bolin.designPattern.singleton.lazyLoading.mutiThred.staticInnerClass;

public class Singleton {
    public Singleton(){

    }
    public  static Singleton getSingleton(){
        return  innerClass.INSTANCE;
    }
    private static  class   innerClass{


//        注意有个内部静态成员变量即可，内部类不再需要有get函数了啊
        private  static  final Singleton INSTANCE=new Singleton();


    }
    /*

    public Singleton(){

    }
    public  static Singleton getSingleton(){
        return  innerClass.getSingleTon();
    }
    private static  class   innerClass{
        private  static  final Singleton instance=new Singleton();
        private static Singleton getSingleTon(){
            return  instance;


        }


    }

     */

}
