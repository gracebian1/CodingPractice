class Solution {
    /* Try partition nums1 at i, then partition nums2 at (m+n+1)/2 - i.
    *  Find i that nums1[i-1] <= nums2[j], and nums2[j-1] <= nums1[i].
    *  So this i is partition around where the median is.
    *  Time: O(log(min(m, n)))
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return 0.f;
        
        int m = nums1.length, n = nums2.length;
        
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        
        int start = 0, end = m;
        
        while (start <= end) {
            int partitionNums1 = start + (end - start) / 2;
            int partitionNums2 = (m + n + 1) / 2 - partitionNums1;
            
            // nothing on left side of nums1. -INF for maxLeftNums1
            int maxLeftNums1 = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            
            // nothing on right side of nums1. INF for minRightNums1
            int minRightNums1 = (partitionNums1 == m) ? Integer.MAX_VALUE : nums1[partitionNums1];
            
            // same for nums2
            int maxLeftNums2 = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int minRightNums2 = (partitionNums2 == n) ? Integer.MAX_VALUE : nums2[partitionNums2];
            
            
            // Partition at correct position
            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if ((m + n) % 2 == 0)
                    return (double)(Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2;
                else 
                    return (double)Math.max(maxLeftNums1, maxLeftNums2);
                
                // Too far on right side for partitionNums1. Need to go left.
            } else if (maxLeftNums1 > minRightNums2) {
                end = partitionNums1 - 1;
                
                // Too far on left side for partitionNums1. Need to go right.
            } else if (maxLeftNums2 > minRightNums1) {
                start = partitionNums1 + 1;
            }
        }
        // Exception: input arrays not sorted
        throw new IllegalArgumentException();
    }
}          