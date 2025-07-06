package org.bolin.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class L155MinStack_250705_1{

    private final Deque<int[]> stack=new ArrayDeque<>();

    public L155MinStack_250705_1() {
        stack.push(new int[]{0,Integer.MAX_VALUE});
    }

    public void push(int val) {
        stack.push(new int[]{val,Math.min(stack.peek()[1],val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
public class L155MinStack {
}
