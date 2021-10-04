class Solution {
    /*
    // HashMap:
    public boolean areOccurrencesEqual(String s) {
        if (s.length() == 1) return true;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int frequency = map.get(s.charAt(0));
        for (char key: map.keySet()) {
            if (map.get(key) != frequency)
                return false;
        }
        return true;
    }
    */
    // char array:
    public boolean areOccurrencesEqual(String s) {
        if (s.length() == 1) return true;
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        int frequency = count[s.charAt(0) - 'a'];
        
        for(int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] != frequency)
                return false;
        }
        return true;
    }
}