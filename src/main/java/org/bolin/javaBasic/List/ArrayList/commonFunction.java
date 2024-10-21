package org.bolin.javaBasic.List.ArrayList;

import java.util.ArrayList;

public class commonFunction {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(99);
        list.add(78);
//        实现了头部插入，但是效果并不好
        list.add(0,77);
        list.remove(0);

    }
}
