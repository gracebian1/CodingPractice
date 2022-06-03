/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Time: O(n), Space: O(1)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode curr = root;
        TreeNode prev = null, next = null, temp = null;
        
        while (curr != null) {
            next = curr.left;
            
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            
            prev = curr;
            curr = next;
        }
        return prev;
    }
}