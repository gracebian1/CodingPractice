class Solution {
    public int singleNumber(int[] nums) {
     // Using set
        if(nums.length == 1) return nums[0];
        
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums){
            if(set.contains(n)){
                set.remove(n);
            }else{
                set.add(n);
            }
        }
        return set.iterator().next();
    }
  
    /*  // Using hashmap
        if(nums.length == 1) return nums[0];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for(int n: nums){
            if(map.get(n) == 1)
                return n;
        }
        return 0;
    }

*/ 
        /*// Using XOR
    
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
     */   
}

