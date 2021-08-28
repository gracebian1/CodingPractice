class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        // left hand side and right hand side pointers
        int left = 0, right = nums.length - 1;
        
        // traverse backwards
        for(int i = nums.length - 1; i >= 0; i--){
            // compare absolute value
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[i] = nums[left] * nums[left];
                left++;
            }else{
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}