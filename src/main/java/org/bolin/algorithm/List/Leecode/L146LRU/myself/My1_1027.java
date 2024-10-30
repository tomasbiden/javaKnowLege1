package org.bolin.algorithm.List.Leecode.L146LRU.myself;

import java.util.HashMap;

// 13 - 42     6 这次自己的算法还要更加优秀
public class My1_1027 {
    Node head;

    Node tail;
    int size=0;

    int capacity;

    HashMap hashMap=new HashMap<Integer,Node>();

//    注意不能有括号的啊
    public  class Node{
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key,int val){
            this.key=key;
            this.val=val;

        }
//        空构造也是需要有的阿
        public  Node(){

        }
    }

    public My1_1027(int capacity) {
        this.capacity=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;



    }
    public void moveToTail(Node node){
        node.pre.next=node.next;

        node.next.pre=node.pre;

        addNewToTail(node);

    }
    public  void addNewToTail(Node node){
        node.pre=tail.pre;
        node.next=tail;

        tail.pre.next=node;
        tail.pre=node;
    }

    public int get(int key) {
//        这个括号很关键的阿
        Node node = (Node) hashMap.get(key);
        if(node==null){
            return -1;
        }
        moveToTail(node);
        return  node.val;


    }

    public void put(int key, int value) {

        Node mapGetNode = (Node) hashMap.get(key);
        if(mapGetNode!=null){
//            一其实并不用修改hashMap，第二hashMap存储的是节点而不是value
//            hashMap.replace(key,value);
            moveToTail(mapGetNode);
            mapGetNode.val=value;
            return;
        }

        Node newNode = new Node(key, value);
        if(size==capacity){
            hashMap.remove(head.next.key);
            head=head.next;
            hashMap.put(key,newNode);
            addNewToTail(newNode);

        }else {
//            这个else不能漏掉了阿, 这个put 也不能漏掉了阿
            hashMap.put(key,newNode);
            addNewToTail(newNode);
            size++;
        }




    }

}
