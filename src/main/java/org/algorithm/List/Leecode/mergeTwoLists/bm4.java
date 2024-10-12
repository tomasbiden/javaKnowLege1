
package org.algorithm.List.Leecode.mergeTwoLists;


import org.algorithm.List.Test.Test1;
import org.algorithm.List.model.ListNode;

public class bm4 {
    public  static final  char str[]=new char[]{'a','b','c'};

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pHead1 ListNode类
         * @param pHead2 ListNode类
         * @return ListNode类
         */
        public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
            //这里一定要注意可能为空
            if (pHead1 == null && pHead2 == null) {
                return null;
            }
            if (pHead1 == null) {
                return pHead2;
            }
            if (pHead2 == null) {
                return pHead1;
            }
            if (pHead1.val > pHead2.val) {
                ListNode save = pHead2;
                pHead2 = pHead1;
                pHead1 = save;
            }
            ListNode tou = pHead1;
            while (pHead2 != null) {
                if (pHead1.next == null) {
                    pHead1.next = pHead2;
//                    return pHead1;  错误返回
                    return tou;
                }

                if (pHead1.next.val < pHead2.val) {
                    pHead1 = pHead1.next;
                } else {
                    ListNode sHead2 = pHead2.next;
                    pHead2.next = pHead1.next;
                    pHead1.next = pHead2;

                    pHead2 = sHead2;
                    pHead1 = pHead1.next;

                }
            }

//            return  pHead1;
            return tou;


        }

        public static void main(String[] args) {
            ListNode head1 = Test1.test1();
            ListNode head2 = Test1.test2();
            ListNode merge = Merge(head1, head2);
//            System.out.println(merge.val);
//            PrintList.print(merge);
//            ListNode listNode9 = new ListNode(9);
//            ListNode listNode91=listNode9;
//            listNode9=head1;
//            listNode9.val=4;
//            System.out.println(listNode91.val);
              int b=0;
              b=b++;
              int c=b++;
              System.out.println(bm4.str);
              bm4.str[2]='d';
            System.out.println(bm4.str);







        }
    }

}
