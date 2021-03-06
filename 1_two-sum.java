class Solution{
    public int[] twoSum(int[]nums, int target){
        // initiate new empty array 
        int[] result = new int[2];
        
        // set "array Value" as "map Key", "array Index" as "map Value"
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);  
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}