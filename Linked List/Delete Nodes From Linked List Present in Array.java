// Problem: Delete Nodes From Linked List Present in Array
// Link: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
// Approach: Linked List

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);   
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr.next != null){
            if(set.contains(curr.next.val)){
                curr.next = curr.next.next;
            }
            else curr = curr.next;
        }
        return dummy.next;
    }
}