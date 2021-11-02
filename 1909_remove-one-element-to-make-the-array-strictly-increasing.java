class Solution {
    public boolean canBeIncreasing(int[] nums) {
        // Count how many changes need to be made
        int count = 0; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                
                // Already got 1 change before
                if (count == 1) return false;
                
                // If no change occurred before, update the count
                count++;  
                
                // Compare current num with num 2 indices previously
                // e.g., [1,6,10,5,20]
                if (i >= 2 && nums[i] <= nums[i - 2])
                    
                    // Update the smaller num with bigger num
                    nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}