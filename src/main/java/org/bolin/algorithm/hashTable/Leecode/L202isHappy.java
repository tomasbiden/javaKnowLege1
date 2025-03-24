package org.bolin.algorithm.hashTable.Leecode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class L202isHappy {

    public  int[] getArrayByn(int n){
        ArrayList<Integer> list = new ArrayList<>();
        while (n!=0){
            list.add(n%10);
            n/=10;
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        return  array;


    }

    public boolean isHappy_250323_1(int n) {
        int[] arrSquare=new int[10];
        for(int i=0;i<10;i++){
            arrSquare[i]=i*i;
        }
//        sum 初始赋为n
        int sum=n;
        HashSet<Integer> integerHashSet = new HashSet<>();
        while (sum!=1){
            sum=0;
            int[] arrayByn = getArrayByn(n);
            for(int i=0;i<arrayByn.length;i++){
                int value=arrayByn[i];
//                注意这里是vlaue 而不是i啊
                sum+=arrSquare[value];
            }
            if(integerHashSet.contains(sum)){
                return false;
            }else {
                integerHashSet.add(sum);
                n=sum;
            }
        }
        return true;





    }
}
