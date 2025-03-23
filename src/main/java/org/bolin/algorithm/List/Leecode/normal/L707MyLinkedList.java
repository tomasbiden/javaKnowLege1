package org.bolin.algorithm.List.Leecode.normal;

public class L707MyLinkedList {
    ListNode head;
    ListNode tail;

    int size=0;
    public class ListNode{
        int value;
        ListNode prev;
        ListNode next;

        public  ListNode(int value){
            this.value=value;
        }
    }
    public L707MyLinkedList(){
        head=new ListNode(-1);
        tail=new ListNode(-1);
        head.prev=null;
        head.next=tail;
        tail.prev=head;
        tail.next=null;
    }
    public ListNode getListNodeByIndex(int index){
        if(index>=(size)){
            return null;
        }
        ListNode cur=head;
        for(int i=0;i<=index;i++){
            cur=cur.next;
        }
        return  cur;
    }
    public int get(int index) {
        if(index<size){
            ListNode cur=head;
            for(int i=0;i<=index;i++){
                cur=cur.next;
            }
            return cur.value;
        }else {
            return -1;
        }

    }
    void addAtIndex(int index,int value){
        if(index>size){
            return;
        }
        ListNode newListNode = new ListNode(value);
        if(index==size){

            newListNode.next=tail;
            newListNode.prev=tail.prev;

            tail.prev.next=newListNode;
            tail.prev=newListNode;
            size++;
            return;
        }

        ListNode preListNode=getListNodeByIndex(index-1);
        newListNode.prev=preListNode;
        newListNode.next=preListNode.next;

        preListNode.next.prev=newListNode;
        preListNode.next=newListNode;
        size++;

    }
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public Boolean judgeValid(int index){
        if(index>=size){
            return  false;
        }else {
            return  true;
        }
    }

    public void deleteAtIndex(int index) {
        if(!judgeValid(index)){
            return;
        }

        ListNode deletePrev = getListNodeByIndex(index - 1);
        deletePrev.next.next.prev=deletePrev;
        deletePrev.next=deletePrev.next.next;
        size--;

    }

}
