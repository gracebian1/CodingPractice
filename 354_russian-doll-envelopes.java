class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // First dimension: in ascending order
        // If first dimension is equal, sort second dimension in descending order
         Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });
        
        // Transform 2D array problem to 1D array problem
        // Build a new array for second dimension
        int[] secondDimension = new int[envelopes.length];
        
        for (int i = 0; i < envelopes.length; i++) { 
            // Extract value from original 2D array
            secondDimension[i] = envelopes[i][1];
        }
        
        // Return the length for longest increasing subsequence
        return lengthOfLIS(secondDimension);
    }
    
     private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int result: dp) {
            max = Math.max(max, result);
        }
        return max;
    }
}