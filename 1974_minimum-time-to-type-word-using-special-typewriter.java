class Solution {
    public int minTimeToType(String word) {
        char[] letters = word.toCharArray();
        
        int count = 0;
        char prev = 'a';
        
        for (int i = 0; i < letters.length; i++) {
            char curr = letters[i];
            
            // Get gaps of two directions
            int gap = Math.abs(letters[i] - prev);
            int reverseGap = 26 - gap;
            
            count += Math.min(gap, reverseGap); 
            
            // Moving forward 
            prev = curr;
        }
        // Add count for typing operation to each letter
        return count + letters.length;
    }
}