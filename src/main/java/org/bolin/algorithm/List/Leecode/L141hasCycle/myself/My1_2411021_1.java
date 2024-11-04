package org.bolin.algorithm.List.Leecode.L141hasCycle.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class My1_2411021_1 {
//    1-3
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return  false;

    }
}
