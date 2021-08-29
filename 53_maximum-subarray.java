class Solution {
    public int maxSubArray(int[] nums) {
        
        // set two pointers
        int max_so_far = nums[0]; 
        int curr_max = nums[0];
    
        // Kadane's algorithm
        for(int i = 1; i < nums.length; i++){
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}