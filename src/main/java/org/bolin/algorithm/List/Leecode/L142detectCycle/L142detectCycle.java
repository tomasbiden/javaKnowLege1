package org.bolin.algorithm.List.Leecode.L142detectCycle;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L142detectCycle_250719_1 {
    public ListNode detectCycle(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        while (fast != null && fast.next != null) {
            //      先走再判断了啊
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode curA = head;
                ListNode curB = slow;
                while (curB != curA) {
                    curA = curA.next;
                    curB = curB.next;
                }
                return curA;
            }

        }
//       1: return dummyNode 错误
        return null;
    }

    public static void main(String[] args) {
        // 创建节点
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        // 构造链表
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        // 创建环：最后一个节点指向 pos = 1 的位置，即 node1
        node3.next = node1;
        L142detectCycle_250719_1 l142detectCycle2507191 = new L142detectCycle_250719_1();
        l142detectCycle2507191.detectCycle(head);

    }
}

public class L142detectCycle {

    public ListNode detectCycle_250323(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        int intersectCount = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = dummyNode;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        L142detectCycle l142detectCycle = new L142detectCycle();
        ListNode listNode = l142detectCycle.detectCycle_250323(listNode1);
        l142detectCycle.detectCycle(listNode1);
        int h = 1;

    }
}
