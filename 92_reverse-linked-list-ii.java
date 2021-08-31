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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)  return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        // iterate till the right point (one step before the starting point)
        for (int i = 1; i < left; i++){
            prev = prev.next;
        }
        
        // a pointer to the starting point of the sublist to be reversed
        ListNode start = prev.next;
        // a pointer to the node that will be reversed next
        ListNode reversed = start.next;
               
        for (int i = left; i < right; i++){
            start.next = reversed.next;
            reversed.next = prev.next;
            prev.next = reversed;
            reversed = start.next;
        }
        return dummy.next;
    }
}