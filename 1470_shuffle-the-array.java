class Solution {
    // O(1) space, same as 1920:
    // Use one formula to connect two variables without extra space
    public int[] shuffle(int[] nums, int n) {
        
        // Change the right half of array:
        // Constraints: 1<=n<=500, 1<=element<=1000, 2*n = len
        // 1024 could be other numbers as long as larger than 1000
        
        for (int i = n; i < 2*n; i++) {
            nums[i] = (nums[i] * 1024) + nums[i-n];
        }
       
        int index = 0;
		
        // To get back the original values: by pairs  
        for(int i = n; i < 2*n; i++){
            
            // % to get the x value
            nums[index] = nums[i] % 1024;
            
            // / to get the y value
            nums[index + 1] = nums[i] / 1024;
            
            // move forwards 2 steps
            index += 2;
        }
        return nums;
    }
}