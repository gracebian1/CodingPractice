class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        
        int maxStep = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(maxStep < i){
                return false;
                // can reach to the end
            }else if(maxStep >= nums.length - 1){
                return true;
            }else{
                // i + nums[i] represents the farthest jump from current location
                maxStep = Math.max(i + nums[i], maxStep);
            }
        }
        // see if it could reach the end
        return maxStep >= nums.length - 1;
    }
}