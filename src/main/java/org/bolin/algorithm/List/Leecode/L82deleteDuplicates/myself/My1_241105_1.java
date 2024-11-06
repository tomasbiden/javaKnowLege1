package org.bolin.algorithm.List.Leecode.L82deleteDuplicates.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

/*
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
           ListNode dummyNode=new ListNode(-10);
        dummyNode.next=head;
        ListNode cur=dummyNode;
        while (cur.next!=null&&cur.next.next!=null){

//            ListNode tmp=cur.next.next.next; 放到这里是错误的啊
//            之前将cur 直接向前走而没有保存 cur ，新建一个 ListNode变量，导致了节点的未改变
            if(cur.next.val==cur.next.next.val){
                ListNode tmp=cur.next.next.next;
                int value=cur.next.val;
                while (tmp!=null&&tmp.val==value){
                    tmp=tmp.next;
                }
                cur.next=tmp;

            }else {
                cur=cur.next;
            }

        }
        return  dummyNode.next;
    }
}
 */
public class My1_241105_1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(Integer.MAX_VALUE);
//        这个不能漏掉了啊
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            int flag=0;
//            注意空异常
            if(cur.next!=null&&cur.val==cur.next.val){
                int x=cur.val;
//                非空判断很重要的啊
                while (cur!=null&&cur.val==x){
                    cur=cur.next;
                }
                pre.next=cur;
            }else {
                pre=cur;
                cur=cur.next;
            }



        }
        return  dummy.next;
    }
}
