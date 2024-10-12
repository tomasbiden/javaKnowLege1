package org.algorithm.codeSuiXiangLu.List.fifthSwapPairs;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class first {
    public static ListNode swapPairs(ListNode head){
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
//        ListNode cur=head;
        ListNode cur=dummyNode;
        ListNode firstNode;
        ListNode secondNode;
        ListNode tmp;
//        注意一定要加上 cur.next!=null 当cur.next=null 时 ，cur.next.next会报出空指针异常
        while (cur.next!=null&&cur.next.next!=null){
            firstNode=cur.next;
            secondNode=cur.next.next;
            tmp=cur.next.next.next;
            cur.next=secondNode;
            secondNode.next=firstNode;
            firstNode.next=tmp;
//            cur=tmp;  错误，cur 是要到下一个交换节点的前面节点
            cur=firstNode;
        }
        return dummyNode.next;
    }
}
