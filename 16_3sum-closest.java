class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array 
        Arrays.sort(nums);
        
        // Get the initial sum of 1st, 2nd, and last elements
        int result = nums[0] + nums[1] + nums[nums.length-1];
        
        // Ending index is < len-2
        for (int i = 0; i < nums.length - 2; i++) {
            // Two pointers
            int left = i+1, right = nums.length - 1;
            
            while (left < right) {
                // Get the sum for 3 new elements
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                // Update the result sum
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}