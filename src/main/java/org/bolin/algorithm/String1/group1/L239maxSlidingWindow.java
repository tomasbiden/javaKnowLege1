package org.bolin.algorithm.String1.group1;

import java.util.LinkedList;

public class L239maxSlidingWindow {
    public void poll(LinkedList<Integer> linkedList,int value){
        if(linkedList.size()>0&&linkedList.getFirst()==value){
            linkedList.removeFirst();
        }
    }
    public void push(LinkedList<Integer> linkedList,int value){
        while (linkedList.size()>0&&linkedList.getLast()<value){
            linkedList.removeLast();
        }
        linkedList.addLast(value);
    }
    public int[] maxSlidingWindow_250329_1(int[] nums, int k) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for(int i=0;i<k;i++){
            integerLinkedList.push(nums[i]);
        }
        int[] result=new int[nums.length];
        int i=0; int j=k-1;
        while (j<nums.length){
            result[i]=integerLinkedList.getFirst();

            poll(integerLinkedList,nums[i]);
            i++;

            j++;
            push(integerLinkedList,nums[j]);

        }
        return result;

    }

    public int[] maxSlidingWindow_250329_2(int[] nums, int k) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for(int i=0;i<k;i++){
            push(integerLinkedList,nums[i]);
        }
        int[] result=new int[nums.length-(k-1)];
        int i=0; int j=k-1;
        while (j<nums.length){
            result[i]=integerLinkedList.getFirst();

            poll(integerLinkedList,nums[i]);
            i++;

            j++;
//            注意数组越界问题阿
            if(j<nums.length){
                push(integerLinkedList,nums[j]);
            }


        }
        return result;

    }
}
