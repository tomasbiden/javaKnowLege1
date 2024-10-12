package org.save1.codeSuiXiangLu.List.seventhListintersect;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class first {
    public ListNode deleteListLastNode(ListNode headA,ListNode headB){
        ListNode head1=headA;
        ListNode head2=headB;
        ListNode curA=head1;
        ListNode curB=head2;
        int len1=0;
        int len2=0;
        while (curA!=null){
//            注意指针后走不能漏掉啊
            curA=curA.next;
            len1++;
        }
        while (curB!=null){
            curB=curB.next;
            len2++;
        }
        if(len2>len1){
            int tmp=len1;
            len1=len2;
            len2=tmp;
            ListNode tmpNode= head2;
            head2=head1;
            head1=tmpNode;
        }

        int gap=len1-len2;
        curA=head1;
        curB=head2;
        while (gap>0){
            curA=curA.next;
            gap--;
        }

        while (curA!=null){
            if(curA==curB){
                return  curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
