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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)   return null;
        
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }
    
    // helper method with new parameters
    private TreeNode helper(int[] nums, int low, int high){
        if (low > high) return null;
        // find the middle 
        int mid = low + (high - low) / 2;
        // build new tree with mid node as root
        TreeNode root = new TreeNode(nums[mid]);
        // call helper recursively
        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);
        return root;
    }
}