package org.bolin.algorithm.DP.Leecode.L279numSquares;

import java.util.Arrays;

class L279numSquares_2507015_1 {
    public int numSquares(int n) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, Integer.MAX_VALUE);
        return dfs(n,memory);
    }

    public int dfs(int n, int[] memory) {
        System.out.println(n);
        if(n==0){
            return 0;
        }
        if(memory[n]!=Integer.MAX_VALUE){
            return memory[n];
        }
//       1：i不能等于0啊
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
//           +1注意放外面
            memory[n] = Math.min(memory[n], dfs(n - i * i, memory) +1);
        }
        return memory[n];
    }
    public static void main(String[] args){

        L279numSquares_2507015_1 l279numSquares25070151 = new L279numSquares_2507015_1();
        int i = l279numSquares25070151.numSquares(38);

    }
}

public class L279numSquares {
}
