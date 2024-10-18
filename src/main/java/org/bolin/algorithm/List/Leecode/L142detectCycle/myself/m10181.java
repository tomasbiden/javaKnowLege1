package org.bolin.algorithm.List.Leecode.L142detectCycle.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class m10181 {
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
                ListNode index=head;
                while (index!=slow){
                    slow=slow.next;
                    index=index.next;
                }
                return  index;
            }




        }
        return  null;



    }
}
