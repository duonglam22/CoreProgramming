package com.leetcode;
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class FindAllDuplicates {
    public boolean isPalindrome(ListNode head) {
       ListNode low = head;
        ListNode quick = head;
        Stack<ListNode> listNodeStack = new Stack<>();
        boolean flag = false;
        listNodeStack.push(low);
        while (quick.next != null && quick.next.next != null) {
            low = low.next;
            quick = quick.next.next;
            listNodeStack.push(low);
            if (quick.next == null) {
                flag = true;
            }
        }
        if(!flag)
            low = low.next;
        if (low == null)
            return true;
        while (!listNodeStack.isEmpty()) {
            ListNode node = listNodeStack.pop();
            if (node.val != low.val)
                return false;
            low = low.next;
        }
        return true;
    }
}
