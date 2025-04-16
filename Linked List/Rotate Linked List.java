// Problem: Rotate Linked List
// Link: https://leetcode.com/problems/rotate-list/description/
// Approach: Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0){
            return head;
        }
        ListNode tail = head;
        int count =1;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        if( k % count == 0){
            return head;
        }
        k = k % count;
        tail.next = head;
        ListNode newLastNode = findNthNode(head, count-k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }
    public static ListNode findNthNode(ListNode temp, int k){
        int count = 1;
        while(temp != null){
            if(count == k){
                return temp;
            }
            count++;
            temp = temp.next;
        }
        return temp;
    }
}