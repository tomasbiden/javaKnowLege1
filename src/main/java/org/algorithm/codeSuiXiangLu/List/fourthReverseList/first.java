package org.algorithm.codeSuiXiangLu.List.fourthReverseList;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class first {
    public static ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode pre=null;
        ListNode tmp=null;
        while (cur!=null){
           tmp=cur.next;
           cur.next=pre;

           pre=cur;
           cur=tmp;
        }
        return  pre;

    }
}
