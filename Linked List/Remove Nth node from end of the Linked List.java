// Problem: Remove Nth node from end of the Linked List
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Approach: Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count==n){
            ListNode newHead = head.next;
            return newHead;
        }
        int res = count - n;
        temp = head;

        while(temp != null){
            res--;
            if(res==0){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}