class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // e.g., nums1[1,3,5,7,0,0,0,0] m = 4
        // nums2 = [2,4,6,8] n = 4
        
        int last = m + n - 1;     // last index of merged array
        m--;                      // last index of nums1
        n--;                      // last index of nums2
        
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){
                nums1[last] = nums1[m];
                last--;
                m--;
            }else{
                nums1[last] = nums2[n];
                last--;
                n--;
            }
        }
        //if nums2 still got elements left
        if(n >= 0){
            for(int i = 0; i <= n; i++){
                nums1[i] = nums2[i];
            }
        }
    }
}