class Solution {
    /*
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int p = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
    */
    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        
        int fast = 1, slow = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[fast] == nums[fast-1]) fast++;
            else{
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
}