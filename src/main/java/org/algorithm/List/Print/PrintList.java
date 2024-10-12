package org.algorithm.List.Print;


import org.algorithm.List.model.ListNode;

public class PrintList {
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}
