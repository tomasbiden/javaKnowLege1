package org.bolin.byteDance;

public class P47 {

    public static int judgePerfect(int x,int l,int r){
        if(x%2==0&&(x>=l&&x<=r)){
            return 1;
        }else {
            return  0;
        }
    }

    public static int solution(int n, int l, int r, int[] a) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int result=0;
        for(int i=0;i<n;i++){
            result+=judgePerfect(a[i],l,r);
        }
        return  result;
    }
}
