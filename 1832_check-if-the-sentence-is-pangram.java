class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letter = new int[26];
        for (char c: sentence.toCharArray()) {
            letter[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            letter[i]--;
            if (letter[i] < 0)
                return false;
        }
        return true;
    }
    
    /*
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c: sentence.toCharArray()) {
            set.add(c);
        } 
        return set.size() == 26;
    }
    */
}