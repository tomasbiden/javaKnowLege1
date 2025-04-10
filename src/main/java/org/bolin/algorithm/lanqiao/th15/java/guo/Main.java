package org.bolin.algorithm.lanqiao.th15.java.guo;

public class Main {

//    你连互质的概念都没有搞清楚的啊
    public static Long  square(Long x,int n){
        Long result=1L;
        for(int i=1;i<=n;i++){
            result*=x;
        }
        return result;
    }
    public static Long function1(Long x,Long max){
        Long result=x-1;
        for(int i=1;i<=(x-1);i++){
            result*=(x);
            if(result>max){
                result%=max;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Long max= square(10L,9);
        int intMax=max.intValue();

        Long result=function1(2023L,max);
        System.out.println(result);


    }
}
