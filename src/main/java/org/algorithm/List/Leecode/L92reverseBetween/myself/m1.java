package org.algorithm.List.Leecode.L92reverseBetween.myself;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class m1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==right){
            return  head;
        }
        if(head.next==null){
            return  null;
        }
        ListNode  dummyNode=new ListNode(-1);
        dummyNode.next=head;

        ListNode reversePre;
        reversePre=dummyNode;
//      走 left-1步
        for(int i=left-1;i>0;i--){
            reversePre=reversePre.next;
        }
        ListNode reverseFirst=reversePre.next;

        ListNode pre=reverseFirst;
        ListNode cur=pre.next;
//        走right-left步
       for(int i=right-left;i>0;i--){
           ListNode curNext=cur.next;
           cur.next=pre;
           pre=cur;
           cur=curNext;
       }
       reversePre.next=pre;
       reverseFirst.next=cur;
       return  dummyNode.next;


    }
    public  ListNode reverse(ListNode head ){
        if(head==null||head.next==null){
            return  head;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            ListNode curNext=cur.next;
            if(pre==head){
                pre.next=null;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return pre;
    }
}
