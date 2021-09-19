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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        
        ListNode curr1 = l1, curr2 = l2;
        ListNode dummy = new ListNode(0), prev = dummy;
        
        int nextDigit = 0;
        int carry = 0;
        
        while (curr1 != null || curr2 != null) {
            if (curr1 != null) {
                nextDigit += curr1.val;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                nextDigit += curr2.val;
                curr2 = curr2.next;
            }
            nextDigit += carry;
            if (nextDigit >= 10) {
                nextDigit -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            prev.next = new ListNode(nextDigit);
            prev = prev.next;
            nextDigit = 0;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        } 
        return dummy.next;   
    }
}