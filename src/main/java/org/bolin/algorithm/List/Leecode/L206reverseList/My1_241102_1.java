package org.bolin.algorithm.List.Leecode.L206reverseList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class My1_241102_1 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;

            cur.next=pre;

            pre=cur;
            cur=curNext;
        }
        return  pre;
    }
}
