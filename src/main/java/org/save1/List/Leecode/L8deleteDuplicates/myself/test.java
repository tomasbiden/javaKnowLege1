package org.save1.List.Leecode.L8deleteDuplicates.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class test {

    public ListNode deleteDuplicates(ListNode head) {
//        这里研究的是如何对链表进行前后遍历
         ListNode  dummyNode=new ListNode(-8);
         dummyNode.next=head;
         ListNode pre=dummyNode;
         ListNode cur=dummyNode.next;
         while (cur!=null){
             pre=cur;
             cur=cur.next;
         }
         return  dummyNode;
    }
}
