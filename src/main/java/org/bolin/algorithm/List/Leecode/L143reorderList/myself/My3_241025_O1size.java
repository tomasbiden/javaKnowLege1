package org.bolin.algorithm.List.Leecode.L143reorderList.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class My3_241025_O1size {
    public ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }
        ListNode  pre=null;
        ListNode  cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;

            cur.next=pre;

            pre=cur;
            cur=curNext;
        }
        return  pre;
    }

    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        /*
        ListNode cur=head;
        int len=1;

        while (cur.next!=null){
            cur=cur.next;
            len++;
        }
//        让 中间那个 数子放到右边去
        int mid=(0+len-1)/2;

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode leftTail=dummy;
        for(int i=0;i<=mid;i++){
            leftTail=leftTail.next;
        }

         */
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode leftTail=slow;
        ListNode rightHead=leftTail.next;
        leftTail.next=null;

        ListNode reverseRight = reverseList(rightHead);

        ListNode leftNode=head;
        ListNode rightNode=reverseRight;

        while (rightNode!=null){
            ListNode  leftNext=leftNode.next;

//            ListNode  rightNext=reverseRight.next;  不是这里的啊
            ListNode rightNext=rightNode.next;

            leftNode.next=rightNode;
//            奇数时 left.next为null ,导致了缺少了一个元素
//            这里还是有问题啊 时rightNode.next而不是 rightNext.next啊
            rightNode.next=leftNext;



            leftNode=leftNext;
            rightNode=rightNext;
        }






    }
}
