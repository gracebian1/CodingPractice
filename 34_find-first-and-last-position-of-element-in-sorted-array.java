class Solution {
    // Time: O(logn), Space: O(1)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int firstIndex = helper(nums, target, true);
        
        if (firstIndex == -1)
            return new int[]{-1, -1};
        
        int secondIndex = helper(nums, target, false);
        
        return new int[]{firstIndex, secondIndex};
    }
    
    private int helper(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                if (isFirst) {
                    if (start == mid || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (end == mid || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
                
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}