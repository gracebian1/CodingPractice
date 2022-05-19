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
    // Time: O(n), Space: O(n)
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = getLowestCommonAncestor(root, startValue, destValue);
        
        StringBuilder ancestorToStartSB = new StringBuilder();
        StringBuilder ancestorToDestSB = new StringBuilder();
        
        traverse(ancestor, startValue, ancestorToStartSB);
        traverse(ancestor, destValue, ancestorToDestSB);
        
        String s = "U";
        // All left sides --> 'U'
        s = s.repeat(ancestorToStartSB.length());
        return s + ancestorToDestSB.toString();
    }
    
    private TreeNode getLowestCommonAncestor(TreeNode root, int node1, int node2) {
        if (root == null || root.val == node1 || root.val == node2) 
            return root ; 
        
        TreeNode left = getLowestCommonAncestor(root.left, node1, node2);
        TreeNode right = getLowestCommonAncestor(root.right, node1, node2);
        
        if (left != null && right != null) 
            return root;
        
        return left == null ? right : left;
    }
    
    // backtracking
    private boolean traverse(TreeNode ancestor, int targetValue, StringBuilder sb) {
        if (ancestor == null) 
            return false;
        if (ancestor.val == targetValue) 
            return true;
        
        sb.append('L');
        if (traverse(ancestor.left, targetValue, sb)) 
            return true;
        
        sb.setCharAt(sb.length() - 1, 'R');
        if (traverse(ancestor.right, targetValue, sb)) 
            return true;
        else 
            sb.setLength(sb.length() - 1);
        
        return false;
    }
}