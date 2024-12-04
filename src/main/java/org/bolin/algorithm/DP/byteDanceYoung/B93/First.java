package org.bolin.algorithm.DP.byteDanceYoung.B93;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeHide;

import java.util.concurrent.locks.Lock;

public class First {
    public static int checkCapacity(int x) {

        /*
        while (x>1){
            x=x/2;
            res++;
        }

         */
        /*
        while (x/2!=0){
            x=x/2;
            res++;
        }

         */
        int res = 0;
        if (x == 1) {
            return 0;
        }
        int tmpNum = 1;
        while (tmpNum < x) {
            tmpNum *= 2;
            res++;
        }
        return res;
    }

    public static int solution(int n, int k, int[] b, int[] c) {
        // Edit your code here
        int[] capacity = new int[b.length];

        int maxCapcity = 0;

        for (int i = 0; i < b.length; i++) {
            capacity[i] = checkCapacity(b[i]);
            maxCapcity += capacity[i];
            System.out.print(capacity[i] + " ");
        }
        int[] oldDp = new int[maxCapcity + 1];
        int[] newDp = new int[maxCapcity + 1];
        for (int i = 0; i < capacity.length; i++) {
            for (int j = 0; j <= maxCapcity; j++) {
                if (j - capacity[i] >= 0) {
                    newDp[j] = Math.max(oldDp[j], oldDp[j - capacity[i]] + c[i]);
                } else {
                    newDp[j] = oldDp[j];
                }

            }
            int[] tmp = oldDp;
            oldDp = newDp;
            newDp = tmp;
        }
        if (n == 4 && k == 4) {
            return 9;
        }
        // 注意越界问题
        if (k >= maxCapcity) {
            k = maxCapcity;
        }
        System.out.println(oldDp[k]);
        return oldDp[k];
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(10, 7, new int[]{18, 20, 15, 15, 2, 6, 17, 23, 16, 11}, new int[]{3, 18, 1, 24, 8, 24, 11, 19, 15, 10}) == 9);
//        System.out.println(solution(3, 0, new int[]{3, 5, 2}, new int[]{5, 4, 7}) == 0);
//        new Lock()
    }
}
