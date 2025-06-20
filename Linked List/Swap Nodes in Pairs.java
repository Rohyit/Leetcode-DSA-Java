// Problem: Swap Nodes in Pairs
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
// Approach: Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyNode = new ListNode();
        ListNode currNode = head;
        ListNode prevNode = dummyNode;

        while(currNode != null && currNode.next != null){
            prevNode.next = currNode.next;
            currNode.next = prevNode.next.next;
            prevNode.next.next = currNode;
            prevNode = currNode;
            currNode = currNode.next;
        }
        return dummyNode.next;
    }
}