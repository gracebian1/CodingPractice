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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                // first add to the list 
                list.add(curr.val);
                // then push to the stack
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return list;    
    }
    
/*    // Recursive:
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> list){
        if(root == null) return list;
        
        list.add(root.val);
        
        if(root.left != null)
            helper(root.left, list);
        
        if(root.right != null)
            helper(root.right, list);
        
        return list;
    }
 */
}