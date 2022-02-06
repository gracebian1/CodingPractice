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
    // Time: O(nlogk); Space: O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for (ListNode head: lists) {
            if (head != null)
                heap.offer(head);
        }
        
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        
        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;
            
            if (curr.next != null)
                heap.offer(curr.next);
        }
        return dummy.next;
    }
}