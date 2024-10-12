package org.save1.List.Leecode.L141hasCycle.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class my1 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return  false;
        }
        if(head.next==head){
            return  true;
        }

        ListNode fastP=head;
        ListNode slowP=head;
        while (fastP!=null&&fastP.next!=null){
            fastP=fastP.next.next;
            slowP=slowP.next;
            if(fastP==slowP){
                ListNode index1=fastP;
                ListNode index2=slowP;
                while (index2!=index1){
                    index1=index1.next;
                    index2=index2.next;
                }
                return  true;
            }

        }
        return false;

    }
}
