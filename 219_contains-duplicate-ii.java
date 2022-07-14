class Solution {
    /*
    // Time: O(n), Space: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;
        
        if (k <= 0)
            return false;
        
        // value: index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k))
                return true;
            
            map.put(nums[i], i);
        }
        return false;
    }
    */
    
    // Time: O(n), Space: O(min(n, k))
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;
        if (k <= 0)
            return false;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    } 
}