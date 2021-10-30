class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        
        // Define as int, add(double) to final result
        int sum = 0, max = Integer.MIN_VALUE;
    
        for (int i = 0; i < nums.length; i++) {
            
            // Add all numbers currently to index i to sum
            sum += nums[i];
            
            // If the last index is out of k's range, subtract the 1st element
            // (index need to subtract 1, since array is 0-indexed)
            if (i > k - 1)
                sum -= nums[i - k];
            
            // Update the max
            if (i >= k - 1)
                max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}