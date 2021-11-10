class Solution {
    public int numIdenticalPairs(int[] nums) {
       // Constraints: 1 <= nums.length <= 100
    
        // New 0-indexed int array
        int[] bucket = new int[101];
        
        for (int n: nums) {
            // original int value to be array index
            // count the frequency of each number
            bucket[n]++;
        }
        
        int result = 0;
        
        // If a number appears t times, t*(t-1)/2 good pairs with this number
        for (int t: bucket) {
            result += t * (t-1) / 2;
        }
        return result;
    }
}