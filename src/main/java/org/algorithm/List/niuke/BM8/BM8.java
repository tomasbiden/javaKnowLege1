package org.algorithm.List.niuke.BM8;

import org.algorithm.List.Print.PrintList;
import org.algorithm.List.Test.Test1;
import org.algorithm.List.model.ListNode;

public class BM8 {
    public static ListNode FindKthToTailTwoPointer (ListNode pHead, int k) {
        /**
         * 注意还有栈与递归的方法，但是空间复杂度较高
         *
         */
        if(pHead==null){
            return  null;
//            不要漏掉了啊
        }
        if(k<=0){
            return  null;
//            这种特例不要漏掉了啊
        }
        ListNode pre=pHead;
        ListNode back=pHead;
        for(int i=2;i<=k;i++){
            pre=pre.next;
            if(pre==null){
                return  null;
            }
        }
        while(pre.next!=null){
            pre=pre.next;
            back=back.next;
        }
        return  back;
    }
    public static void main(String[] args){
        ListNode testBM8 = Test1.testBM8();
        ListNode listNode = FindKthToTailTwoPointer(testBM8, 2);
        PrintList.print(listNode);
//        System.out.println(listNode.val);


    }
}
