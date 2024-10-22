package org.save1.codeSuiXiangLu.List.thirdDesignMyLinkList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

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
          ListNode newnode = new ListNode(val);
          newnode.next=head.next;
          head.next=newnode;
          size++;
//          注意size

      }
      public void addAtTail(int val){
         ListNode current=head;
         while (current.next!=null){
             current=current.next;
         }
          ListNode newnode = new ListNode(val);
         current.next=newnode;
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
          ListNode newnode = new ListNode(val);
         newnode.next=pre.next;
         pre.next=newnode;
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
