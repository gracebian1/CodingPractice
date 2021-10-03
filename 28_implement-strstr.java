class Solution {
    public int strStr(String haystack, String needle) {
        // haystack and needle consist of lowercase letters only
        if (needle == null || needle.length() == 0 || haystack.equals(needle))  
            return 0;
        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) 
            return -1;
        
        int h = haystack.length(), n = needle.length();
        
        // Attention to window size
        for (int i = 0; i <= h - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) 
                return i;
        }
        return -1;
    }  
}