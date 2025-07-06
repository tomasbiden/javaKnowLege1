package org.bolin.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class L739dailyTemperatures_250705_1{
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] ans=new int[temperatures.length];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=len-1;i>=0;i--){
//            1:注意是有temperatures
            while (!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return ans;
    }
}
public class L739dailyTemperatures {
}
