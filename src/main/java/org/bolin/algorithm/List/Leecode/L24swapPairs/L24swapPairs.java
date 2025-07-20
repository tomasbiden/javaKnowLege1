package org.bolin.algorithm.List.Leecode.L24swapPairs;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class  L24swapPairs_250720_1{
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode cur=head.next;

        ListNode swapHead = swapPairs(head.next.next);
        pre.next=swapHead;
        cur.next=pre;
        return cur;

    }
}
public class L24swapPairs {
}
