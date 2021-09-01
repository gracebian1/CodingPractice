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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // two pointers
        ListNode fast = dummy, slow = dummy;
        
        // move fast to maintain the correct gap n 
        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }
        
        // move two pointers till the end of list
        // now slow is at the correct position, n positions to the end
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        // skip the nth node from the end
        slow.next = slow.next.next;
        return dummy.next;
    }
}