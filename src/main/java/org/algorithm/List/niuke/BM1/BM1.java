package org.algorithm.List.niuke.BM1;

public class BM1 {

    public static  class ListNode {
        int val;
       ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode ReverseList (ListNode head) {
            ListNode zuo=null;
            ListNode you=head;
            while(you!=null){
                ListNode zaiyou=you.next;
                you.next=zuo;
                zuo=you;
                you=zaiyou;

            }
            return zuo;
        }
        
       
    }

    public static void main(String[] args){

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        listNode7.next=null;

        ListNode tmp=listNode5;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }

        ListNode reversedList = new Solution().ReverseList(listNode5);

        tmp=reversedList;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }




    }


}


