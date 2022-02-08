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
    /*
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
    */
    
    // Merge with divide and conquer
    // Time: O(nlogk), k lists, n nodes;  Space: O(1)
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i+interval < lists.length; i=i+interval*2) {
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
            if (l1 != null)
                curr.next = l1;
            if (l2 != null)
                curr.next = l2;
            
            return dummy.next;
    }
}