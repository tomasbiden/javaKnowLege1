package org.bolin.javaBasic.List.LinkedList;

import java.util.LinkedList;

public class commonFunction {
    public static void main(String[] args){
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(12);
        queue.add(566);

        queue.addFirst(45);

        Integer poll = queue.poll();
        Integer poll1 = queue.poll();
        System.out.println(poll+" " +poll1);


    }
}
