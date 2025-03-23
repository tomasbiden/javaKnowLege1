package org.bolin.algorithm.List.Leecode.L19removeNthFromEnd;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class L19removeNthFromEnd {

    public ListNode removeNthFromEnd_0323_fixedDistance_1(ListNode head, int n) {
//        ListNode curPointer=head;
//        ListNode afterPoniter=head;
        ListNode dummyNode=new ListNode(-1);
        ListNode curPointer=dummyNode;
        ListNode afterPoniter=dummyNode;
        dummyNode.next=head;
        for(int i=1;i<=n;i++){
            afterPoniter=afterPoniter.next;
        }
        while (afterPoniter!=null&&afterPoniter.next!=null){
            curPointer=curPointer.next;
            afterPoniter=afterPoniter.next;
        }
        ListNode deletedNodePre=curPointer;
        deletedNodePre.next=deletedNodePre.next.next;
        return  dummyNode.next;


    }
}
