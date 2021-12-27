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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) 
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // Boolean value: even or odd level
        boolean even = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
           
            // linked list to add at front and back
            LinkedList<Integer> temp = new LinkedList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
                
                if (even)
                    temp.add(curr.val);
                else
                    temp.addFirst(curr.val);
            }
            result.add(temp);
            
            // Toggle the boolean value
            even = !even;
        }
        return result;
    }
}