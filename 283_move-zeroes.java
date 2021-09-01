class Solution {
    public void moveZeroes(int[] nums) {
        // Insert point
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        
        int insertPoint = 0;
        for(int n: nums){
            if(n != 0){
                nums[insertPoint] = n;
                insertPoint++;
            }
        }
        
        for(int i = insertPoint; i < nums.length; i++){
            nums[i] = 0;
        }
    }  
   
/*      // two pointers
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        
        int fast = 0, slow = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
  */
    
}