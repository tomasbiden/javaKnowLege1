package org.bolin.algorithm.List.Leecode.L146LRU.myself;

import java.util.HashMap;

public class My1_241108_1 {
    int size;
    int capacity;

    Node head;
    Node tail;

//    注意这个括号的啊
    HashMap<Integer,Node> hashMap=new HashMap<>();


    public My1_241108_1(int capacity){
        this.capacity=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;

    }



//    注意是不用括号的啊
    class  Node{
        Node pre;
        Node next;
        int key;
        int val;
//        注意这里有个public
        public Node(){

        }
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }

    }
    public void moveToTail(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;

        addToTail(node);
    }

    public  void addToTail(Node node){

        node.pre=tail.pre;
        node.next=tail;

        tail.pre.next=node;
        tail.pre=node;
    }


    public int get(int key) {
        Node mapGetNode = hashMap.get(key);
        if(mapGetNode==null){
            return -1;
        }else {
            moveToTail(mapGetNode);
            return mapGetNode.val;
        }

    }

    public void put(int key, int value) {
        Node mapGetnode = hashMap.get(key);
        if(mapGetnode!=null){
            moveToTail(mapGetnode);
            mapGetnode.val=value;
            return;
        }

        Node newNode = new Node(key, value);
        if(size==capacity){
//            这两句不能漏掉，注意不是head.val 也不是 head.key啊
            hashMap.remove(head.next.key);
            hashMap.put(key,newNode);
            head=head.next;
            addToTail(newNode);


        }else{
            addToTail(newNode);
            size++;
            hashMap.put(key,newNode);
        }




    }
}
