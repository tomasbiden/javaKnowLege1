package org.bolin.designPattern.singleton.lazyLoading.onThred;

public class Singleton {
    // 1、私有化构造⽅法
    private Singleton() {
    }

    // 2、定义⼀个静态变量指向⾃⼰类型
    private static Singleton instance;

    // 3、对外提供⼀个公共的⽅法获取实例
    public static Singleton getInstance() {
// 判断为 null 的时候再创建对象
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}