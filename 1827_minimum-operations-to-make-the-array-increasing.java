class Solution {
    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        
        int count = 0;
        
        // Start from index 1 to avoid outOfIndex
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                
                // Calculate the gap between the two, add to count
                count += nums[i - 1] - nums[i] + 1;
                
                // Update the smaller one to maintain the increasing order
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }
}