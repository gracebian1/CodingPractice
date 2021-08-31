/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null) return false;
        
        if(head.next == head) return true;
        // two pointers
        ListNode fast = head, slow = head;
        
        // check if two pointers will meet eventually 
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}

/**
Using HashSet:

class Solution{
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        if(head.next == head) return true;
        
        Set<ListNode> set = new HashSet<>();
        
        ListNode curr = head;
        while(curr.next != null){
            if(set.contains(curr)){
                return true;
            }else{
                set.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }
}
*/