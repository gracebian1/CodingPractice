class Solution {
    /*
    // HashMap:
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int result = 0;
        
        // map.values(): a Collection view of the values in map
        for (int count: map.values()) {
            result += count % 2 == 0 ? count : count - 1;
        }
        
        // +1: add an additional odd character, to make result longer
        return result == s.length() ? result : result + 1;
    }
    */
    
    // HashSet:
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                result++;
            }else {
                set.add(c);
            }
        }
        //+1: add an additional odd char, to make result longer
        return result*2 == s.length() ? result*2 : result*2 + 1;
    }
}