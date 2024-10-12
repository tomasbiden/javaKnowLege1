package org.save1.List.Leecode.L206reverseList.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class first_improve1 {
    public ListNode reverseList(ListNode head) {

        if(head==null||head.next==null){
            return  head;
        }

        ListNode pre=null;
        ListNode cur=head;
//     improve:   pre从 null开始就不用进行头结点判断了
        while (cur!=null){

            ListNode curNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return pre;
    }
}
