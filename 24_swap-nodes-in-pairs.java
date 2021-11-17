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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode newHead = head.next;
        
        while (curr != null && curr.next != null) {
            ListNode temp = curr;
            
            curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;
            
            // Move curr to the next position
            curr = temp.next;
            
            // Connect temp to the next correct node
            if (curr != null && curr.next != null)
                temp.next = curr.next;
        }
        return newHead; 
    }
}