package org.save1.List.Print;


import org.save1.List.model.ListNode;

public class PrintList {
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}
