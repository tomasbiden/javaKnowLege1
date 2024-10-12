package org.algorithm.List.niuke.BM11;

import org.algorithm.List.model.ListNode;

import java.util.*;


public class BM11 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        Stack<ListNode>  s1=new Stack<>();
        Stack<ListNode>  s2=new Stack<>();

        ListNode l1=head1;
        ListNode l2=head2;
        while (l1!=null){
            s1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            s2.push(l2);
            l2=l2.next;
        }
        int carry=0;
        ListNode nextNode=null;
        while (!s1.empty()||!s2.empty()){
            if(!s1.empty()&&s2.empty()){
                ListNode p1 = s1.pop();
                int value=p1.val+carry;

                carry=value/10;
                ListNode newNode=new ListNode(value%10);
                newNode.next=nextNode;
                nextNode=newNode;


                continue;
            }
            if(s1.empty()&&!s2.empty()){
                ListNode p2 = s2.pop();
                int value=p2.val+carry;

                carry=value/10;
                ListNode newNode=new ListNode(value%10);
                newNode.next=nextNode;
                nextNode=newNode;
                continue;

            }

            ListNode p1=s1.pop();
            ListNode p2=s2.pop();
            int value=p1.val+p2.val+carry;


            carry=value/10;
            ListNode newNode=new ListNode(value%10);
            newNode.next=nextNode;
            nextNode=newNode;



        }

        return  nextNode;


    }
    public  static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        /*
        // 添加元素
        pq.add(3);
        pq.add(1);
        pq.add(2);
        Integer.compare()
        // 检索并移除头部元素
        System.out.println(pq.poll()); // 输出: 1

        // 检索头部元素但不移除
        System.out.println(pq.peek()); // 输出: 2

        // 查看队列大小
        System.out.println(pq.size()); // 输出: 2

        // 遍历队列（注意：优先队列不保证元素的顺序，除非通过迭代器）
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        Integer x=2;
        Integer y=3;
        Hashtable

         */
        String s="sdf";
        System.out.println(s.hashCode());
        ListNode l1=new ListNode(2);
        System.out.println(l1.hashCode());
        System.out.println(l1.toString());
        List<Integer> list;
        ArrayList<String> strings = new ArrayList<>();
        List myList = Arrays.asList(1, 2, 3);

        myList.add(4);//运行时报错：UnsupportedOperationException
        myList.remove(1);//运行时报错：UnsupportedOperationException
        myList.clear();//运行时报错：UnsupportedOperationException


    }
}

