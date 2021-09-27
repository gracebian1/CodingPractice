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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        
        while(pre.next != null){
            if(pre.next.val != val){     // check 'next' val 
                pre = pre.next;
            }else{
                pre.next = pre.next.next;
            }
        }
        return dummy.next;
    }
}