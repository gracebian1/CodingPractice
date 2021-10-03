class Solution {
    /*
    // XOR: 
    // Array without any missing number:  nums[index] = index
    
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }
    */
    
    // Sum of int from 1 to n: 1+2+3+..+n = n(n+1)/2
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int currSum = 0;
        
        for (int num: nums) {
            currSum += num;
        }
        return sum - currSum;
    }
}