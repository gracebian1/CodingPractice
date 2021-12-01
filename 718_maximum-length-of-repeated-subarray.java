class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int maxLen = 0;
        
        // length plus 1, since the 1st one depends on previous (-1 not exist)
        int[][] cache = new int[m + 1][n + 1];
        
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                int num1 = nums1[row - 1];
                int num2 = nums2[col - 1];
                
                if (num1 == num2) {
                    // dp: every next step is based on previous step
                    cache[row][col] = cache[row - 1][col - 1] + 1;
                    
                    // Update the latest max len
                    maxLen = Math.max(maxLen, cache[row][col]);
                }
            }
        }
        return maxLen;
    }
}