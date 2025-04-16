// Problem: Linked List Cycle II
// Link: https://leetcode.com/problems/linked-list-cycle-ii/description/
// Approach: Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}