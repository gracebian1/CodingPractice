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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // Iterative: 
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()){
            // push non-null node to stack
            // keep tracking the left hand side
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            list.add(curr.val);
            // check the right hand side
            curr = curr.right;
        }  
        return list;
    }
    
/*    // Recursive:
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    // helper method with additional parameter
    private List<Integer> helper(TreeNode root, List<Integer> list){
        if(root == null) return list;
        
        if(root.left != null)
            helper(root.left, list);
        
        list.add(root.val);
        
        if(root.right != null)
            helper(root.right, list);
        
        return list;
    } 
*/
}