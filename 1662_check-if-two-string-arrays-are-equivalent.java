class Solution {
    /*
    // StringBuilder:
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for (String w: word1) {
            sb1.append(w);
        }
        
        for (String w: word2) {
            sb2.append(w);
        }
        
        return sb1.toString().equals(sb2.toString());
    }
    */
    
    // O(1) space:
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Outer pointer: each string arr has n words
        // Inner pointer: each word has n chars
        
        // Pointer to each word
        int outer1 = 0, outer2 = 0;
        
        // Pointer to each char
        int inner1 = 0, inner2 = 0;
        
        while (outer1 < word1.length && outer2 < word2.length) {
            
            // Get the first word in each string arr
            String w1 = word1[outer1];
            String w2 = word2[outer2];
            
            // If the char is different, return immediately
            if (w1.charAt(inner1) != w2.charAt(inner2)) 
                return false;
            
            // Keep iterating
            // When at the end of a word, reset inner to 0, and update outer by 1
            if (inner1 < w1.length() - 1) {
                inner1++;
            } else{
                inner1 = 0;
                outer1++;
            }
            
            if (inner2 < w2.length() - 1) {
                inner2++;
            } else {
                inner2 = 0;
                outer2++;
            }
        }
        // Check if reach the end of both arr
        return outer1 == word1.length && outer2 == word2.length;
    }
}