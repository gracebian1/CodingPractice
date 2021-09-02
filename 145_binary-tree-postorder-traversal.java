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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                list.addFirst(curr.val);
                curr = curr.right;
            }else{
                curr = stack.pop();
                curr = curr.left;
            }
        }
        return list;
    }
    
    
/*    // Recursive:
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> list){
        if(root == null) return list;
        
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
        
        return list; 
    } 
    */
}