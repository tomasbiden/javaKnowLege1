package org.bolin.algorithm.List.Leecode.L234isPalindrome;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L243isPalindrome_250719_1{
    public boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode head2 = reverse(middle);
        while (head!=null&&head2!=null){
            if(head.val!=head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;


    }

    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return pre;
    }


    private ListNode findMiddle(ListNode head){
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode slow=dummyNode;
        ListNode fast=dummyNode;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return  slow;
    }
}
public class L243isPalindrome {
}
