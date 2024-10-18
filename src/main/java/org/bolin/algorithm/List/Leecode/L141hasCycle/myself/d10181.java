package org.bolin.algorithm.List.Leecode.L141hasCycle.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class d10181 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return  false;
        }
        ListNode fast=head;
        ListNode slow=head;
//        fast!= null 也不能漏掉的啊
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return  true;
            }
        }


        return false;

    }
}
