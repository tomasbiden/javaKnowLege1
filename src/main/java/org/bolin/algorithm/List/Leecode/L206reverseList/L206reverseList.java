package org.bolin.algorithm.List.Leecode.L206reverseList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class L206reverseList {
    public ListNode reverseList_250323(ListNode head) {
        ListNode pre= null;
        ListNode cur=head;
        if(head==null){
            return head;
        }
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;

            pre=cur;
            cur=next;
        }
        return pre;


    }
}
