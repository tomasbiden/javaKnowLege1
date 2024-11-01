package org.bolin.designPattern.singleton.lazyLoading.mutiThred.enumM;

// 测试类
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;

        // 检查是否为同一个实例
        System.out.println(singleton1 == singleton2); // 输出 true

        // 调用方法
//        singleton1.doSomething(); // 输出 Doing something...
    }
}