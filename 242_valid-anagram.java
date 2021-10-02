class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        // assume consist of lowercase letters only
        int[] letter = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
        }
        
        for (int j = 0; j < t.length(); j++) {
            letter[t.charAt(j) - 'a']--;
            // t holds letter that s does not have
            if (letter[t.charAt(j) - 'a'] < 0)
                return false;
        }
        return true;
    }
}