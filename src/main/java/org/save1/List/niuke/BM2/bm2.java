package org.save1.List.niuke.BM2;


public class bm2 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static  ListNode reverseBetween1 (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode curr=dummyNode;
        ListNode currNext;
        for(int i=0;i<m-1;i++){
            curr=curr.next;
            
        }
        ListNode pre=curr;
        curr=curr.next;
        currNext=curr.next;
        for(int i=0;i<m-n;i++){
            
            pre.next=curr.next;
            curr.next=currNext.next;
            currNext.next=pre.next;
            
            currNext=curr.next;
            
            
            
        }
        return dummyNode.next;
        
      
    }




    public static  ListNode reverseBetween2 (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode curr=dummyNode;
        ListNode currNext;
        for(int i=0;i<m-1;i++){
            curr=curr.next;

        }

        ListNode pre=curr;
        curr=curr.next;
        currNext=curr.next;
        for(int i=0;i<n-m;i++){
            ListNode sPreNext=pre.next;
            pre.next=curr.next;
            curr.next=currNext.next;
//            currNext.next=pre.next;
            currNext.next=sPreNext;

            currNext=curr.next;

//            System.out.println(curr.val+"!");

        }
        return dummyNode.next;


    }

    public static void listNodeReverse(ListNode pre,ListNode curr,ListNode currNext){
        curr.next=currNext.next;
        currNext.next=pre.next;
        pre.next=currNext;

    }

    public static  ListNode reverseBetween3 (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode curr=dummyNode;
        ListNode currNext;
        for(int i=0;i<m-1;i++){
            curr=curr.next;

        }

        ListNode pre=curr;
        curr=curr.next;
        currNext=curr.next;
        for(int i=0;i<n-m;i++){
            listNodeReverse(pre,curr,currNext);
            currNext=curr.next;

        }
        return dummyNode.next;


    }
    public static  ListNode test1(){
        ListNode listNode1 = new ListNode(1);
        ListNode  listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4 );
        ListNode listNode5= new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=null;
       print(listNode1);
        return listNode1;
    }

    public  static  void   main(String[] args){
        ListNode head=test1();
        ListNode listNode = reverseBetween3(head, 2, 4);
     print(listNode);

    }
}
