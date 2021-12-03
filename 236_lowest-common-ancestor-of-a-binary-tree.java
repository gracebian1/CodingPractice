/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    // Recursive:
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null || root == p || root == q)
             return root;
         
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);
         
         if (left != null && right != null)
             return root;
         
         return left != null ? left : right;
    }
    */
    
    // Iterative:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        
        // Map key: child node; Map value: parent node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        // Put in both map and stack TILL map contains both p and q
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode curr = stack.pop();
            
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                stack.push(curr.left);
            }
            
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                stack.push(curr.right);
            }
        }
        
        Set<TreeNode> set = new HashSet<>();
        
        // Loop through to get the parent of p using map 
        while (parentMap.containsKey(p)) {
            set.add(p);
            p = parentMap.get(p);
        }
        
        // Use set to get the common ancestor
        while (!set.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }
}