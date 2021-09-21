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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
        
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                
                if(curr.left != null)
                    queue.offer(curr.left);
                
                if(curr.right != null)
                    queue.offer(curr.right);  
            }
            result.add(level);
        }
        return result;
    }
    /*
    // Recursive:
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;   
    }
    
    private void helper(List<List<Integer>> result, TreeNode node, int level){
        if(node == null) return;
        if(result.size() <= level){
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            result.add(temp);
        }else{
            result.get(level).add(node.val);
        }
        helper(result, node.left, level+1);
        helper(result, node.right, level+1);
    }
    */
}