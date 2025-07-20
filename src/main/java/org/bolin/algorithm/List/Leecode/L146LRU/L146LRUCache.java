package org.bolin.algorithm.List.Leecode.L146LRU;

import java.util.HashMap;
import java.util.Map;

class L146LRUCache_250720_1{

    Node tail;

    Node head;

    int capacity=0;

    int size=0;

    Map<Integer,Node> keyNodeMap;

    private static  class Node{
        Node pre;
        Node next;
        int value;

        int key;

        private Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    public L146LRUCache_250720_1(int capacity) {
        this.head=new Node(-1,-1);
        this.tail=new Node(-2,-2);

        head.next=tail;
        tail.pre=head;

        this.capacity=capacity;
        keyNodeMap=new HashMap<>();
    }

    public int get(int key) {

        Node node = keyNodeMap.get(key);
        if(node!=null){
            addExistsNodeToHead(node);
            return node.value;
        }else {
            return -1;
        }


    }

    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)){
            Node keyNode = keyNodeMap.get(key);
            keyNode.value=value;

            addExistsNodeToHead(keyNode);

        }else{
            if(this.capacity==size){
                //               注意Map的删除
                keyNodeMap.remove(tail.pre.key);
                Node tailPrePre=tail.pre.pre;


                tail.pre=tailPrePre;
                tailPrePre.next=tail;
                size--;
            }
            Node newNode = new Node(key,value);
            keyNodeMap.put(key,newNode);
            addNodeToHead(newNode);
            size++;

        }
    }

    private void addExistsNodeToHead(Node existsNode){
        //       需要先断开node的链接
        existsNode.pre.next=existsNode.next;
        existsNode.next.pre=existsNode.pre;

        addNodeToHead(existsNode);
    }

    private void  addNodeToHead(Node node){


        node.next=head.next;
        node.pre=head;

        head.next.pre=node;
        head.next=node;
    }

    public static void main(String[] args){
        L146LRUCache_250720_1 cache = new L146LRUCache_250720_1(2); // 容量是 2
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 淘汰 key=2
        cache.get(2);       // 返回 -1（未找到）
        cache.put(4, 4);    // 淘汰 key=1
        cache.get(1);       // 返回 -1（未找到）
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4

    }
}
public class L146LRUCache {
}
