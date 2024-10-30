package org.bolin.designPattern.singleton.hungryMan.javaguide;

import java.lang.reflect.Constructor;

public class Singleton {
    // 1、私有化构造⽅法
    private Singleton() {
    }

    // 2、定义⼀个静态变量指向⾃⼰类型
    private final static Singleton instance = new Singleton();

    // 3、对外提供⼀个公共的⽅法获取实例
    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args){


    }
}