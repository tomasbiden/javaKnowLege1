package org.bolin.algorithm.List.Leecode.L92reverseBetween.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class My1_241102_1 {
    public void reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;

            cur.next=pre;

            pre=cur;
            cur=curNext;
        }

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
//        注意临界判断啊
        if(head==null||head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
//        这里不能漏掉了啊
        dummy.next=head;
//        注意设置为 dummy
        ListNode reverseLeftPre=null;
//        注意null来初始化
        ListNode reverseLeft=null;
        ListNode reverseRight=null;
        ListNode reverseRightNext=null;

        ListNode cur=dummy;
        for(int i=0;i<=right;i++){
          if(i==left-1){
              reverseLeftPre=cur;
              reverseLeft=reverseLeftPre.next;
          }
          if(i==right){
              reverseRight=cur;
              reverseRightNext=reverseRight.next;
          }
//          把这行代码放到最后面就没有上面破事了啊
          cur=cur.next;

        }

        reverseRight.next=null;
        reverseList(reverseLeft);

        reverseLeftPre.next=reverseRight;
        reverseLeft.next=reverseRightNext;
        return dummy.next;




    }
}
