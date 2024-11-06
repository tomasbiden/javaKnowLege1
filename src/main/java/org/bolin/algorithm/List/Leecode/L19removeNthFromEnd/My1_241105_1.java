package org.bolin.algorithm.List.Leecode.L19removeNthFromEnd;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;
// 10分钟
/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
             ListNode dummyNode = new ListNode(0);
        dummyNode.next=head;
        ListNode fastIndex=dummyNode;
        ListNode slowIndex=dummyNode;

        for(int i=0;i<=n;i++){
            fastIndex=fastIndex.next;

        }
        while (fastIndex!=null){
            fastIndex=fastIndex.next;
            slowIndex=slowIndex.next;
        }
        if(slowIndex.next!=null){
            slowIndex.next=slowIndex.next.next;
        }
        return  dummyNode.next;

    }
}
 */
public class My1_241105_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummmy=new ListNode(-1);
        dummmy.next=head;
        ListNode fastNode=dummmy;
        ListNode slowNodw=dummmy;
        for(int i=1;i<=(n+1);i++){
            fastNode=fastNode.next;
        }
        while (fastNode!=null){
            fastNode=fastNode.next;
            slowNodw=slowNodw.next;
        }

        ListNode pre=slowNodw;
        pre.next=pre.next.next;
        return  dummmy.next;

    }
}
