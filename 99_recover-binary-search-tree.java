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
    // Time: O(n); Space: O(n)
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode p = null, q = null, prev = null;
        
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            
            if (prev != null && prev.val > curr.val) {
                q = curr;
                
                if (p == null)
                    p = prev;
                else
                    break;
            }
            prev = curr;
            curr = curr.right;
        }
        swap(p, q);   
    }
    
    private static void swap(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
    /*
    TreeNode p = null, q = null, prev = null;
    
    public void recoverTree(TreeNode root) {
        findTwo(root);
        swap(p, q);
    }
    
    private void findTwo(TreeNode root) {
        if (root == null)
            return;
        
        TreeNode curr = root;
        findTwo(curr.left);
        
        if (prev != null && prev.val > curr.val) {
            q = curr;
            
            if (p == null)
                p = prev;
            else
                return;
        }
        prev = curr;
        findTwo(curr.right);
    }
    
    private static void swap(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
    */
}