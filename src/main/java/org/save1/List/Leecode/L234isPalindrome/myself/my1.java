package org.save1.List.Leecode.L234isPalindrome.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class my1 {
    public static void  printBack(ListNode head){
        System.out.println("h1"+head.val);
        if(head==null){
            return ;
        }
        if(head.next!=null){
            printBack(head.next);
            System.out.println("h2"+head.val);

        }else {
            System.out.println("h2"+head.val);

        }
    }
    public boolean isPalindrome(ListNode head) {
        return  true;

    }

    public static  void main(String[] args){
        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(-2);
        ListNode listNode3 = new ListNode(-3);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=null;
        printBack(listNode1);

    }

}
