package org.save1.codeSuiXiangLu.List.sixthDeleteListLastNNode;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class first {
    public ListNode deleteListLastNNode(ListNode head, int n){
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
