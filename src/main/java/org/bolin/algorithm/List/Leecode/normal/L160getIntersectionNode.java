package org.bolin.algorithm.List.Leecode.normal;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class L160getIntersectionNode {
    public ListNode getIntersectionNode_250323_1(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
//        while (curA!=null&&curB!=null&&curA!=curB){
        while ((curA!=null||curB!=null)&&curA!=curB){
            if(curA==null){
                curA=headB;
            }
            if(curB==null){
                curB=headA;
            }

            if(curA==curB){
                break;
            }
//            相等可能出在了重新赋头指针之后啊
            curA=curA.next;
            curB=curB.next;

        }
        return  curA;

    }

    public ListNode getIntersectionNode_250323_2(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
//        while (curA!=null&&curB!=null&&curA!=curB){
        while (curA!=curB){

//            相等可能出在了重新赋头指针之后啊
            curA=curA.next;
            curB=curB.next;
            if(curA==null){
                curA=headB;
            }
            if(curB==null){
                curB=headA;
            }

        }
        return  curA;

    }
}
