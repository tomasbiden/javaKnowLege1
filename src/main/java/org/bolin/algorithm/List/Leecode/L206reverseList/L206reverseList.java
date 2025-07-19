package org.bolin.algorithm.List.Leecode.L206reverseList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class  L206reverseList_250719_1{
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode pre=head;
        ListNode cur=head.next;
//       1:循环依赖问题
        pre.next=null;
        while (cur!=null){
            ListNode curNext=cur.next;

            cur.next=pre;

            pre=cur;
            cur=curNext;
        }
//       return 的是 pre而不是head啊
        return pre;
    }


}
public class L206reverseList {
    public ListNode reverseList_250323(ListNode head) {
        ListNode pre= null;
        ListNode cur=head;
        if(head==null){
            return head;
        }
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;

            pre=cur;
            cur=next;
        }
        return pre;


    }
}
