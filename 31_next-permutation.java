class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        // Search for FIRST digit less than previous digit (backwards)
        // Attention to out of bounds index
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
        }
        
        // i now is FIRST digit found
        if (i >= 0) {
            // Start again from the end, going backwards
            int j = nums.length - 1;
            // Get the FIRST digit larger than digit i
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // Reverse the part of originally descending order to ascending order
        // to make it as small as possible
        reverse(nums, i+1, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}