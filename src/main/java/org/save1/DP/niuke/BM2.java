package org.save1.DP.niuke;

public class BM2 {

    public int jumpFloor (int number) {
        // write code here
        int sum=3;
        int di2=1;
        int di1=2;
        if(number==1){
            return 1;
        }
        if(number==2){
            return 2;
        }

        for(int i=3;i<=number;i++){
            sum=di1+di2;
            di2=di1;
            di1=sum;
        }
        return sum;

    }
}
