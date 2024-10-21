package org.bolin.javaBasic.util.classExchange.ListSort;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class my1 {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(67);
        list.add(89);

        /* 法一
        String string = list.toString();
        String[] split = string.substring(1,string.length()-1).replaceAll(" ","").split(",");
        List<Integer> collect = Arrays.stream(split).map(splitone->Integer.parseInt(splitone)).collect(Collectors.toList());
        List<Integer> collect2 = Arrays.stream(split).map((splictOne)->{
            return  Integer.parseInt(splictOne);
        }).collect(Collectors.toList());

         */


//        System.out.println(collect);
//        System.out.println();
//        System.out.println(string);


        /*  发二
          String collect1 = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect1);
        String[] split1 = collect1.split(",");
        List<Integer> collect3 = Arrays.stream(split1).map(splitone -> Integer.parseInt(splitone)).collect(Collectors.toList());
        System.out.println(collect3);

         */



        /*  hutools
             String string = list.toString();
        List<String> list1 = Convert.toList(String.class, string);
        List<Integer> collect = list1.stream().map(splictOne -> Integer.parseInt(splictOne)).collect(Collectors.toList());
         */

    }
}
