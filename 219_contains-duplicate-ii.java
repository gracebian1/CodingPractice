class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) return false;
        if (k <= 0) return false;       // Two distinct indices
        
        // Map key--value => Array value---index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            }
            // Attention: map value is array index (not frequency of num)
            map.put(nums[i], i);    
        }
        return false;
    }

    /*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) return false;
        if (k <= 0) return false;          // Two distinct indices
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            // If the gap is larger than k distance
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            // All elements within k distance is in set
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    */
}