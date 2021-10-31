class Solution {
    // O(1) space:
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            int index = nums[i] % len;
            int value = nums[index] % len;
            
        // Use one formula, to connect 'index' and 'value' (since no extra space)
            nums[i] += value * len;
        }
        
        // Get new value
        for (int i = 0; i < len; i++) {
            nums[i] /= len;
        }
        return nums;
    }
}