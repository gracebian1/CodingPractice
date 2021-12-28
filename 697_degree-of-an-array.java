class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        // Map key: integer in nums
        // Map value: array of 3 elements: degree, start index, end index
        
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        
        int maxDegree = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        
        for (int[] temp: map.values()) {
            if (temp[0] > maxDegree) {
                maxDegree = temp[0];
                minLen = temp[2] - temp[1] + 1;
            } 
            if (temp[0] == maxDegree) {
                minLen = Math.min(minLen, temp[2] - temp[1] + 1); 
            }
        }
        return minLen;
    }
}