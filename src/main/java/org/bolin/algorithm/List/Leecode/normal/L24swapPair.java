package org.bolin.algorithm.List.Leecode.normal;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class L24swapPair {
    public ListNode swapPairs_240323_for(ListNode head) {
//        注意添加单一节点的判断了啊
        if(head!=null&&head.next==null){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode pre=dummyNode;
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            ListNode curNextNext=cur.next.next;
            pre.next=cur.next;
            cur.next.next=cur;
            cur.next=curNextNext;

            pre=cur;
            cur=curNextNext;
        }
        return dummyNode.next;


    }

    public ListNode swapPairs_240323_AfterRecursion_main(ListNode head) {

        if(head==null||head.next==null){
            return  head;
        }
        ListNode result=head.next;
        swapPairs_240323_preRecursion_sub(head);
        return  result;

    }
    public ListNode swapPairs_240323_preRecursion_sub(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }

        ListNode pre=head;
        ListNode cur=head.next;
        ListNode curNext=cur.next;
        cur.next=pre;
        pre.next=swapPairs_240323_preRecursion_sub(curNext);

        return cur;
    }

    public ListNode swapPairs_240323_preRecursion_main(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode pre=head;
        ListNode cur=pre.next;
        ListNode haveSwapedHead = swapPairs_240323_preRecursion_main(cur.next);
        cur.next=pre;
        pre.next=haveSwapedHead;
        return cur;

    }
}
