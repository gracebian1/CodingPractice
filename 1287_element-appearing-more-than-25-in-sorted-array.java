class Solution {
    /*
    // Extra space
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n: arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (int n: arr) {
            if (map.get(n) > arr.length / 4)
                return n;
        }
        return -1;
    }
    */

    // O(1) space: Sliding window
    public int findSpecialInteger(int[] arr) {
        int len = arr.length, window = len / 4;

        // Since the arr is sorted
        for (int i = 0; i < len - window; i++) {
            if (arr[i] == arr[i + window]) {
                return arr[i];
            }
        }
        return -1;
    }
}