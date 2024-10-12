package org.save1.DP.niuke;

public class BM1 {
    public int Fibonacci (int n) {
        // write code here
        if(n==1||n==2){
            return 1;
        }
        int zuo=1;
        int zhong=1;
        int you=2;
        for(int i=3;i<=n;i++){
            you=zuo+zhong;
            zuo=zhong;
            zhong=you;
        }
        return zhong;
    }

//    https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=295&tqId=23255&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany
    public static void main (String[] args){


    }
}
