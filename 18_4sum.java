class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        
        Arrays.sort(nums);
        
        // Ending index is < len-3
        for (int i = 0; i< nums.length - 3; i++) {
            // Skip the duplicate element
            if (i > 0 && nums[i] == nums[i-1])   
                continue;
            
            // Ending index is < len-2
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip the duplicate element
                if (j > i+1 && nums[j] == nums[j-1])   
                    continue;
                
                // Two pointers
                int left = j + 1, right = nums.length - 1;
                
                while (left < right){
                    // Get sum of the 4 elements
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target){
                        // Add as Arrays.asList()
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip the duplicate elements
                        while (left < right && nums[left] == nums[left+1]) 
                            left++;
                        while (left < right && nums[right] == nums[right-1]) 
                            right--;
                        
                        // Move forward
                        left++;
                        right--;
                        
                    }else if (sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}