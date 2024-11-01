package org.bolin.algorithm.List.Leecode.L234isPalindrome.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

/*
class Solution {
    public  static ListNode reverseList(ListNode head){
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



    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return  false;
        }
        ListNode endOfFirstHalf = findEndOfFirstHalf(head);
        ListNode backHalfHead = reverseList(endOfFirstHalf.next);

        ListNode  tmpBackHalfHead=backHalfHead;

        ListNode head1=head;
        boolean result=true;
        while (tmpBackHalfHead!=null){

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
}
 */
// 10-

public class My1_241031_1 {
    public  ListNode reverseList(ListNode head){

        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;

            cur.next=pre;

            pre=cur;
            cur=curNext;
        }
        return  pre;

    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
//        这里有问题的于自己的思考，自己走的是中间偏右了啊
        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
//         midNode 为正中间偏左，因此较长
        ListNode midNode=slow;
        ListNode rightReverse1 = reverseList(midNode.next);
//        midNode.next=null;

        ListNode right=rightReverse1;
        ListNode left=head;
        while (right!=null){
            if(right.val!=left.val){
//                这里过早return 导致了回文链表未知正确接上
                ListNode rightReverse2 = reverseList(rightReverse1);
//                midNode.next=rightReverse2;
                return false;
            }else {
                left=left.next;
                right=right.next;
            }
        }
        ListNode rightReverse2 = reverseList(rightReverse1);
//        midNode.next=rightReverse2;


        return true;
    }
    public static void main(String[] args){
        int[] array=new int[]{1,1,7,1};
        ListNode  dummy=new ListNode(-1);

        ListNode pre=dummy;

        for (int i : array) {
//             array[i] 错误的啊 ，本身就是array[i]了
            ListNode cur = new ListNode(i);

            pre.next=cur;

            pre=cur;
        }
        ListNode head=dummy.next;

        My1_241031_1 my12410311 = new My1_241031_1();
        boolean palindrome = my12410311.isPalindrome(head);

        System.out.println(palindrome);

        while (head!=null){

            System.out.print(head.val+"  ");
            head=head.next;
        }

    }

}
