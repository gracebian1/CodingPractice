class Solution {
    public String longestNiceSubstring(String s) {
        if (s == null || s.length() < 2) return "";
        char[] arr = s.toCharArray();
        
        // Add all char to set
        Set<Character> set = new HashSet<>();
        for (char c: arr) 
            set.add(c);
        
        // Traverse the char array
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            
            // If contains both upper and lower cases, move to the next index
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c)))
                continue;
            
            // If canNot find both upper and lower cases, divide into 2 substrings by index i
            // call 2 substrings recursively
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            
            // Get the longest/earliest substring
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}