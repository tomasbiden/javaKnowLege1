package org.bolin.algorithm.List.Leecode.L206reverseList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class my1 {

    public ListNode reverseList2(ListNode head) {
      if(head==null){
          return null;
      }
      ListNode pre=head;

      ListNode cur=pre.next;
        pre.next=null;
      while (cur!=null){
          ListNode curNext=cur.next;
          cur.next=pre;

          pre=cur;
          cur=curNext;
      }
      return  pre;




    }

    public ListNode reverseList(ListNode head) {

        ListNode pre=null;

        ListNode cur=head;

        while (cur!=null){
            ListNode curNext=cur.next;
            cur.next=pre;

            pre=cur;
            cur=curNext;
        }
        return  pre;




    }
}
