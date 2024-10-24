package org.bolin.javaBasic.mixKnowleget.mix1;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Strem_array_list {
    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        List<Object> collect = list.stream().map(x -> {
            return x - 1;
        }).collect(Collectors.toList());

//        左边不用括号， 右边有括号就不用return 有 大括号就需要return
        List<Object> collect2 = list.stream().map(x -> (x-1)).collect(Collectors.toList());
        int[] dp=new int[5];
        int[] array = Arrays.stream(dp).map(x -> (x + 1)).toArray();



        int sum = Arrays.stream(dp).sum();



        String string = Arrays.toString(dp);

        String string1 = dp.toString();

        System.out.println(string+" " +string1);


        List<Integer> list1 = Arrays.asList(1, 2, 3);



        int[] dp2=new int[2];
        dp2[0]=1; dp2[1]=3;

//        这三句代码最为关键的啊,这三句代码是核心的啊
        IntStream stream = Arrays.stream(dp2);
        Stream<Integer> boxed = stream.boxed();
        IntStream intStream = boxed.mapToInt(Integer::intValue);



        List<Integer> list2 = Arrays.stream(dp2).boxed().collect(Collectors.toList());

        Stream<Integer> stream1 = list2.stream();
        stream1.collect(Collectors.toList());

        Integer[] array1 = list2.toArray(new Integer[0]);
        Stream<Integer> stream2 = list2.stream();

        int[] array2 = Arrays.stream(array1).mapToInt(Integer::intValue).toArray();

        int[] newArray=new int[2];
        List<Integer> newList = Arrays.stream(newArray).boxed().map(x->(x+1)).collect(Collectors.toList());
        System.out.println(newList);
        int[] newArray2 = newList.stream().mapToInt(Integer::intValue).map(x->(x+3)).toArray();


//
        String string2 = Arrays.toString(newArray);
        System.out.println(string2);



    }
}
