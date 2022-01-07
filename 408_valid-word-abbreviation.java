class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || word.length() == 0 || abbr == null || abbr.length() == 0)
            return false;
    
        int i = 0, j = 0;
        
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            
            // Check first occurrence of number 
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            
            // Get numeric value in abbr
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            int gap = Integer.valueOf(abbr.substring(start, j));
            
            // Get the index in word after jumping x positions
            i += gap;
        }
        return i == word.length() && j == abbr.length();
    }
}