class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        // Two pointers:
        int fast = 0, slow = 0;
        
        while(fast < nums.length){
            if(nums[fast] == val){
                fast++;
            }else{
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                fast++;
                slow++;
            }
        }
        return slow;   
        */
        // One pointer:
        int insertPoint = 0;
        
        for(int n: nums){
            if(n != val){
                nums[insertPoint] = n;
                insertPoint++;
            }
        }
        return insertPoint;
    }
}