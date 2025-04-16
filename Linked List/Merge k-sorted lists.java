// Problem: Merge k-sorted Linked Lists
// Link: https://leetcode.com/problems/merge-k-sorted-lists/description/
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode list : lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            temp.next = minNode;
            temp = minNode;

            if(minNode.next != null){
                minHeap.offer(minNode.next);
            }
        }
        return dummyNode.next;
    }
}