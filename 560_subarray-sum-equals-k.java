class Solution {
    // Array NOT sorted, may include positive and negative numbers
    // Sub array could overlap
    
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int sum = 0, count = 0;
        
        // map key --> cumulative sum
        // map value --> how many times this sum occurred
        
        Map<Integer, Integer> map = new HashMap<>();
        // Put the initial sum 0 into map, along with its frequency 1
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            // Get the cumulative sum
            sum += nums[i];
            // Update count if map contains the same key
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);                
            }
            // Put each new cumulative sum into map as a new entry 
            map.put(sum, map.getOrDefault(sum, 0) + 1);           
        }
        return count;
    }
}