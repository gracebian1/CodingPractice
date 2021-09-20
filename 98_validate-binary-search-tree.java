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
/*
 //Use Integer instead of int to cover Integer.MAX_VALUE and Integer.MIN_VALUE cases.
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode curr, Integer max, Integer min){
        if (curr == null){
            return true;
        }
        if ((max != null && curr.val >= max) || (min != null && curr.val <= min)){
            return false;
        }
        return isValidBST(curr.left, curr.val, min) && isValidBST(curr.right, max, curr.val);
    }
}
*/

//Iterative:
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = null;
         
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            } 
            root = stack.pop();
            
            if(p != null && root.val <= p.val) return false;
            
            p = root;
            root = root.right;
        }
        return true;
    }
}



