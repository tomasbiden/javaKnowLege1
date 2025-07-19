package org.bolin.algorithm.List.Leecode.L160getIntersectionNode;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L160getIntersectionNode_250719_1{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpCurA=headA;
        ListNode tmpCurB=headB;
        while (tmpCurA!=tmpCurB){
            if(tmpCurA==null){
//            1:错误    tmpCurA=tmpCurB;
                tmpCurA=headB;
            }else {
                tmpCurA=tmpCurA.next;
            }

            if(tmpCurB==null){
//                tmpCurB=tmpCurA;
                tmpCurB=headA;
            }else {
                tmpCurB=tmpCurB.next;
            }
        }
        return tmpCurA;
    }
}
public class L160getIntersectionNode {
}
