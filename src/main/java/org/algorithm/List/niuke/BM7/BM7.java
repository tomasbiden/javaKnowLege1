package org.algorithm.List.niuke.BM7;


import org.algorithm.List.Test.Test1;
import org.algorithm.List.model.ListNode;

public class BM7 {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;
        ListNode slow1=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow1=slow1.next;
            if(fast==slow1){
                ListNode slow2=pHead;
                while (slow2!=slow1){
                    slow2=slow2.next;
                    slow1=slow1.next;
                }
                return  slow1;

            }

        }
        return  null;
    }

    public  static void main(String[] args){
        ListNode pHead = Test1.testBM7();
        ListNode listNode = EntryNodeOfLoop(pHead);
        System.out.println(listNode.val);



    }
}
