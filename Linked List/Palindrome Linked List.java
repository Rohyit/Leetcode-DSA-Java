// Problem: Palindrome Linked List
// Link: https://leetcode.com/problems/palindrome-linked-list/description/
// Approach: Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    private static ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }    
}