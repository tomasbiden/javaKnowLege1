package org.bolin.algorithm.List.Leecode.L142detectCycle.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class My1_241031_1 {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return  null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode curPosition=fast;
                ListNode backPosition=head;
                while (curPosition!=backPosition){
                    curPosition=curPosition.next;
                    backPosition=backPosition.next;
                }
                return  backPosition;
            }
        }
        return null;


    }
}
