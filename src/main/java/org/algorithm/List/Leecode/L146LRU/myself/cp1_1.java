package org.algorithm.List.Leecode.L146LRU.myself;

import java.util.HashMap;
import java.util.Map;

class cp1_1{

    public class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev=null;
        DLinkedNode next=null;
        public DLinkedNode(){

        }
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private  int capacity;
    private  int size;


//    注意要有括号且不能快捷引入
   private Map<Integer,DLinkedNode> cache=new HashMap<Integer,DLinkedNode>();

   private  DLinkedNode head;
   private DLinkedNode tail;
    public  cp1_1(int capacity) {
//        注意这里必须先初始化再进行复制
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;

    }
    public DLinkedNode addHead(int key,int value){
        DLinkedNode dLinkedNode = new DLinkedNode(key, value);
        dLinkedNode.prev=head;
        dLinkedNode.next=head.next;
        dLinkedNode.next.prev=dLinkedNode;
        head.next=dLinkedNode;
        return dLinkedNode;

    }
    public  void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;

    }
    public void moveHead(DLinkedNode node){
//       注意这两个的顺序不能变，变了会导致多删除问题，好像还不是这个问题
        removeNode(node);
        DLinkedNode dLinkedNode = addHead(node.key, node.value);

//      在moveHead时，一定要注意更新cache的节点,我这个代码写的有问题啊
        cache.put(node.key,dLinkedNode);
    }
    public DLinkedNode removeTail(){
        DLinkedNode tPrev = tail.prev;
        removeNode(tPrev);
        return tPrev;

    }

    public int get(int key) {
        if(cache.containsKey(key)){
//            访问时，注意要移动到前面去啊.
            moveHead(cache.get(key));
            return cache.get(key).value;

        }else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLinkedNode dLinkedNode = cache.get(key);
            dLinkedNode.value=value;

            moveHead(dLinkedNode);



        }else {
            size++;
            DLinkedNode addHeadNode = addHead(key, value);
            cache.put(key,addHeadNode);

            if(size>capacity){
                DLinkedNode dLinkedNode = removeTail();
                cache.remove(dLinkedNode.key);
//                注意这句代码不能漏掉了啊
                size--;
            }
        }

    }

    public static void main(String [] args){
        cp1_1 cp11 = new cp1_1(2);
        cp11.put(1,1);

        cp11.put(2,2);
        cp11.get(1);
        cp11.put(3,3);
        cp11.put(3,4);
        cp11.put(3,5);
        System.out.println(cp11.get(1));

    }
}
