package org.bolin.algorithm.List.Leecode.normal;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class L203removeElements {

    public ListNode removeElements(ListNode head, int val) {
            ListNode dummyNode=new ListNode();
            dummyNode.next=head;
            ListNode cur=dummyNode;
            while (cur!=null&&cur.next!=null){
                if(cur.next.val==val){
                    cur.next=cur.next.next;
                }
                cur=cur.next;
            }
            return  dummyNode.next;
    }
}
