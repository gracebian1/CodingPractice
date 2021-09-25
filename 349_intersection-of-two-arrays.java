class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return null;
        if(nums1 == null || nums2 == null) return null;
        if(nums1.length == 0 && nums2.length == 0) return new int[0];
        
        Set<Integer> set = new HashSet<>();
        for(int n: nums1){
            if(!set.contains(n))
                set.add(n);   
        }
        
        List<Integer> list = new ArrayList<>();
        for(int m: nums2){
            if(set.contains(m)){
                list.add(m);
                set.remove(m);     // make sure each element in final array is unique
            }       
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}