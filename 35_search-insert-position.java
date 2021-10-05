class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int left = 0, right = nums.length - 1;
        
        while (left < right) {                     // Attention: < HERE 
            int mid = left + (right - left) / 2;   // to avoid overflow
            
            if (nums[mid] == target) 
                return mid;
            else if (nums[mid] < target) 
                left = mid + 1;
            else
                right = mid;
        }
        // Deal with the last element
        return nums[left] < target ? left + 1: left;
    }
}