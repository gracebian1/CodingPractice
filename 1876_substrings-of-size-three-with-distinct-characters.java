class Solution {
    public int countGoodSubstrings(String s) {
        if (s == null || s.length() < 3) return 0;
        
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        
        // Two pointers
        int left = 0, right = 0;
        
        // count: number of char in substring
        // sum:   total number of good substrings
        int count = 0, sum = 0;
        
        while (right < arr.length) {
            if (!set.contains(arr[right]) && count < 3) {
                set.add(arr[right]);
                right++;
                count++;
            } else {
                set.remove(arr[left]);
                left++;
                count--;
            }
            // Update 'sum' for each time 'count' reaches 3
            if (count == 3) {
                sum++;
            }
        }
        return sum;
    }

    /*
    public int countGoodSubstrings(String s) {
        Set<Character> set = new HashSet();
        int sum = 0;
        
        // Attention to the ening index
        for (int i = 0; i < s.length() - 2; i++) {
            
            // Get substring of each possible 3 chars
            String subStr = s.substring(i, i + 3);
            
            for (char c: subStr.toCharArray()) {
                set.add(c);
            }            
            if (set.size() == 3) {
                sum++;
            }
            set.clear();
        }
        return sum;
    }
    */
}