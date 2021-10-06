class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        // Try from the largest side
        // Attention: i > 1
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < nums[i-1] + nums[i-2])
                return nums[i] + nums[i-1] + nums[i-2];
        }
        return 0;
    }
}