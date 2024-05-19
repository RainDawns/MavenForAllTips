package com.raindown.practise;



/**
 * date: 2024/4/26
 *
 * @author raindown
 */
public class Main2 {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 反转前半部分的链表，变成两个链表
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 节点数为奇数时，特殊处理下
        if (fast != null)
            slow = slow.next;
        // 对比两个链表的值是否完全相同
        while (slow != null) {
            if (slow.val != pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }


    class ListNode{
        int val;
        ListNode next;
    }
}
