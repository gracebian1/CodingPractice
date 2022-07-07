class Solution {
    public boolean canJump(int[] nums) {
        
        // A GOOD index: currIndex + nums[currIndex] >= leftmostGoodIndex
        // Traverse backwards
        
        if (nums == null || nums.length == 0) return false;
        
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) 
                lastIndex = i;
        }
        return lastIndex == 0;
    }
}