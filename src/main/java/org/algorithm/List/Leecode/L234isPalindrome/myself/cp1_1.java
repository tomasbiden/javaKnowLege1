package org.algorithm.List.Leecode.L234isPalindrome.myself;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class cp1_1 {
    public  static  ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }
        ListNode pre=null;
        ListNode  cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;

            pre=cur;
            cur=next;
        }
        return pre;
    }

    public  static  ListNode findEndOfFirstHalf(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return  slow;
    }

    public  static  void pringList(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }



    public static boolean isPalindrome(ListNode head) {
        if(head==null){
            return  false;
        }
        ListNode endOfFirstHalf = findEndOfFirstHalf(head);
        ListNode backHalfHead = reverseList(endOfFirstHalf.next);

        ListNode  tmpBackHalfHead=backHalfHead;
//        pringList(tmpBackHalfHead);
//        pringList(head);

        ListNode head1=head;
        boolean result=true;
        while (backHalfHead!=null){
            if(head1.val==tmpBackHalfHead.val ){
                head1=head1.next;
                tmpBackHalfHead=tmpBackHalfHead.next;
                continue;
            }else{
                result=false;
                break;
            }
        }

        ListNode preBackHalfHead = reverseList(backHalfHead);
        endOfFirstHalf.next=preBackHalfHead;

        return  result;



    }

    public static  void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(-2);
        ListNode listNode3 = new ListNode(-3);
        ListNode listNode4 = new ListNode(1);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=null;
       isPalindrome(listNode1);

    }
}
