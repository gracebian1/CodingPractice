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
    public int maxDepth(TreeNode root) {
        // Iterative: BFS: using queue
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
            
        int count = 0; // counter for max depth
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right); 
                size--;
            }
            count++;
        }
        return count;
    }
   
/*        //DFS: using stack
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        nodes.push(root);
        depths.push(1);

        // counter for maximum depth
        int max = 0;   

        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int depth = depths.pop();

            // if null node, max depth will not be updated
            if(node == null) continue; 

            max = Math.max(max, depth);

            nodes.push(node.left);
            depths.push(depth + 1);

            nodes.push(node.right);
            depths.push(depth + 1);
        }
        return max;
    }
 */   
    
 /*       // Recursive:
        if(root == null) return 0;
        else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
 */
}