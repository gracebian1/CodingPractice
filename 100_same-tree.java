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
 /*   // Recursive
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   */
    // Iterative
    public boolean isSameTree(TreeNode p, TreeNode q){
        Stack<TreeNode> s1 = new Stack<>();       
        Stack<TreeNode> s2 = new Stack<>();
        
        if (p != null) 
            s1.push(p);
        if (q != null) 
            s2.push(q);
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode pn = s1.pop();
            TreeNode qn = s2.pop();
            
            if (pn.val != qn.val) return false;
            
            if (pn.right != null) 
                s1.push(pn.right);
            if (qn.right != null) 
                s2.push(qn.right);
            
            if (s1.size() != s2.size()) return false;
            
            if (pn.left != null) 
                s1.push(pn.left);
            if (qn.left != null) 
                s2.push(qn.left);
            
            if (s1.size() != s2.size()) return false;
         }
         return s1.size() == s2.size(); 
    }
}