class Solution {
    
    // Get the fixed size for array first 
    public int[] decompressRLElist(int[] nums) {
        int resultLen = 0;
        for (int i = 0; i < nums.length; i+=2) {
            resultLen += nums[i];
        }
        
        int[] result = new int[resultLen];
        
        int startPoint = 0;
        for (int i = 0; i < nums.length; i+=2) {
            
            // Arrays.fill(int[] a, int fromIndex, int toIndex, int val) 
            // toIndex exclusive
            
            Arrays.fill(result, startPoint, startPoint + nums[i], nums[i+1]);
            
            // Update startPoint by skipping the gap (previous frequency)
            startPoint += nums[i];
        }
        return result;
    }
    
    /*
    // Build ArrayList first by ignoring the size
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i+=2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i+1]);
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    */
}