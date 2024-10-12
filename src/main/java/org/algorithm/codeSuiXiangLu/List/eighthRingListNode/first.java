package org.algorithm.codeSuiXiangLu.List.eighthRingListNode;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class first {
    public ListNode ringListNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode index1=fast;
                ListNode index2=head;
                while (index2!=index1){
                    index2=index2.next;
                    index1=index1.next;
                }
                return  index2;
            }
        }
        return  null;
    }
}
