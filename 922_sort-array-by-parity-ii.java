class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        // Half even, half odd
        // Starting index variables
        int even = 0, odd = 1;
        
        while (even < nums.length && odd < nums.length) {
            if (nums[even] % 2 != 0) {
                swap(nums, even, odd);
                odd += 2;
            } else {
                even += 2;
            }
        }
        return nums;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}