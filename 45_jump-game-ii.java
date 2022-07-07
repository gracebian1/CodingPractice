class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        
        int count = 0;
        int farthest = 0, currEnd = 0;
        
        // Attention to the last index of i
        for (int i = 0; i < nums.length - 1; i++) {
            
            // Get the farthest jump that can be reached
            // global optimal 
            farthest = Math.max(farthest, i + nums[i]);
            
            // If reached the last position of current jump
            if (i == currEnd) {
                count++;
                currEnd = farthest;
            }
        }
        return count;
    }
}