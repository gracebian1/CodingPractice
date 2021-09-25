class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return null;
        if(nums1 == null || nums2 == null) return null;
        if(nums1.length == 0 && nums2.length == 0) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums1){
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int m: nums2){
            // can NOT use "while"!
            if(map.containsKey(m) && map.get(m) > 0){
                list.add(m);
                map.put(m, map.get(m)-1);
            }
        }
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}