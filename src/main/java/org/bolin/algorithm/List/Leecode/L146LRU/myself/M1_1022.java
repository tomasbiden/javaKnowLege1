package org.bolin.algorithm.List.Leecode.L146LRU.myself;

import java.util.HashMap;

public class M1_1022 {
    int capacity=0;

    int size=0;

    HashMap<Integer,Node>  hashMap=new HashMap<>();

    Node head=null;
    Node tail=null;
    public class Node{
        int key;
        int val;

        Node next=null;

        Node pre=null;

       public  Node(int key,int val){
           this.key=key;
           this.val=val;


        }

        public  Node(){
//           这里不知道为什么不用 new
//           pre=new Node();
//           next=new Node();

        }

    }

    public M1_1022(int capacity) {

        this.capacity=capacity;
        this.head=new Node();
        this.tail=new Node();
        head.next=tail;
        tail.pre=head;


    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            /*
            Node hashGetNode = hashMap.get(key);

            hashGetNode.pre.next=hashGetNode.next;

            hashGetNode.next.pre=hashGetNode.pre;

            hashGetNode.pre=tail.pre;

            tail.pre=hashGetNode;

            hashGetNode.next=tail;

            return hashGetNode.val;

             */

            Node hashGetNode = hashMap.get(key);

            hashGetNode.pre.next=hashGetNode.next;

            hashGetNode.next.pre=hashGetNode.pre;

//            这句代码应该非常重要的啊
            tail.pre.next=hashGetNode;

            hashGetNode.pre=tail.pre;

            tail.pre=hashGetNode;

            hashGetNode.next=tail;

            return hashGetNode.val;

        }else {
            return  -1;
        }


    }

    public void put(int key, int value) {

        Node newnode = new Node(key, value);

        if(hashMap.containsKey(key)){
            Node hashGetNode = hashMap.get(key);

            hashGetNode.pre.next=hashGetNode.next;

            hashGetNode.next.pre=hashGetNode.pre;

            //            这句代码应该非常重要的啊
            tail.pre.next=hashGetNode;

            hashGetNode.pre=tail.pre;

            tail.pre=hashGetNode;

            hashGetNode.next=tail;

            hashGetNode.val=value;

//            hashMap.replace(key,hashGetNode);
//            hashMap不用修改

            return;
        }

        if(size==this.capacity){
            hashMap.remove(head.next.key);
            head=head.next;

            tail.pre.next= newnode;

            newnode.pre=tail.pre;

            newnode.next=tail;

            tail.pre=newnode;

            hashMap.put(key,newnode);

            return;


        }
        size++;
        tail.pre.next= newnode;

        newnode.pre=tail.pre;

        newnode.next=tail;

        tail.pre=newnode;

        hashMap.put(key,newnode);

        return;





    }

    public static void main(String[] args){
        M1_1022 m11022 = new M1_1022(2);

        m11022.put(1,1);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
        m11022.put(2,2);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
        m11022.get(1);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
        m11022.put(3,3);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
        m11022.get(3);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
        m11022.put(2,4);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
        m11022.put(5,5);
        System.out.println(m11022.head.next==null?1:0+" "+m11022.head.next.key+" "+ m11022.head.next.next.key);
//        int x2=m11022.hashMap.get(2).val;
        Boolean x=m11022.hashMap.containsKey(2);
       System.out.println(x);
    }

}
