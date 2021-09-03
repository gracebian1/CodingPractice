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
    // Iterative:
    public boolean isSymmetric(TreeNode root) {
       
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return true;
        
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(queue.size() > 1){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            
            queue.offer(left.left);
            queue.offer(right.right);
            
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
    
 /*   // Recursive:

    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    */
}