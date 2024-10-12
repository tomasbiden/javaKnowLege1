package org.algorithm.List.Leecode.L206reverseList.myself;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class first {
    public ListNode reverseList(ListNode head) {

        if(head==null||head.next==null){
            return  head;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            ListNode curNext=cur.next;
            if(pre==head){
                pre.next=null;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return pre;
    }
}
