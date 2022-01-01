class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];   
        Stack<Integer> stack = new Stack<>();
        
        // Map key: previous smaller num
        // Map value: latter larger num
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int j = 0; j < nums2.length; j++) {
            while (!stack.isEmpty() && stack.peek() < nums2[j]) {
                map.put(stack.pop(), nums2[j]); 
            }
            stack.push(nums2[j]);
        }
        
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        
        for (int i = 0; i < nums1.length; i++) {
          result[i] = map.get(nums1[i]);
        }      
        return result;
    }
}