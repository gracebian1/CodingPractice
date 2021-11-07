class Solution {
    public String sortSentence(String s) {
        // An array of strings for the original s 
        String[] words = s.split(" ");
        
        // Result string array
        String[] result = new String[words.length];
       
        for (String word: words) {
            
            // Get the index (order) of each word
            int index = word.length() - 1; 
            
            // substring(0, index) to get rid of the index
            // Index is at the last position of each word
            result[word.charAt(index) - '1'] = word.substring(0, index);
        }
        // String.join(): return a string joined with a given delimiter
        return String.join(" ", result);
    }
}