class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            
            // Add the item to list
            list.add(nums[i]);
            
            // Update the result sum 
            result += nums[i];
            
            if (result > sum - result)
                return list;
        }
        return list;
    }
}