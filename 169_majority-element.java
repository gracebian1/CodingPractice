class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }   
            if(map.containsKey(n) && map.get(n) > nums.length / 2)
                return n;
        }
        return -1;
    }
}



// Sorting:

// Arrays.sort(nums);
// return nums[nums.length / 2];

// O(nlgn) 