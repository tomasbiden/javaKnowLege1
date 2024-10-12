package org.algorithm.codeSuiXiangLu.List.thirdDesignMyLinkList;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class myLinkList {
     public  int size;
//     注意是size
     ListNode head;
     public myLinkList(){
         size=0;
         head=new ListNode(0);
     }
     public  int get(int index){
         if(index<0||index>=size){
             return -1;
         }
         ListNode currentNode=head;
        for(int i=0;i<=index;i++){
            currentNode=currentNode.next;
        }
        return  currentNode.val;
     }
      public void addAtHead(int val){
          ListNode newNode = new ListNode(val);
          newNode.next=head.next;
          head.next=newNode;
          size++;
//          注意size

      }
      public void addAtTail(int val){
         ListNode current=head;
         while (current.next!=null){
             current=current.next;
         }
          ListNode newNode = new ListNode(val);
         current.next=newNode;
         size++;
      }

      public void addAtIndex(int index,int val){
         if(index>size) {
             return;
          }
         if(index<0){
             index=0;

         }
         ListNode pre=head;
         for(int i=0;i<index;i++){
             pre=pre.next;
         }
          ListNode newNode = new ListNode(val);
         newNode.next=pre.next;
         pre.next=newNode;
         size++;


      }
      public void deleteAtIndex(int index){
         if(index>=size||index<0){
             return;
         }


         ListNode pre=head;
         for(int i=0;i<index;i++){
             pre=pre.next;
         }
         pre.next=pre.next.next;
         size--;
         return;
      }


}
