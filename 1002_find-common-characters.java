class Solution {
    // Use 3 helper functions:
    public List<String> commonChars(String[] words) {
        // First get the first word in words, call 1st helper function
        int[] count = getCount(words[0]);
        
        // Then loop through the rest word in words, call 2nd and 3rd helper functions
        for (int i = 1; i < words.length; i++) {
            int[] curr = getCount(words[i]);
            compareCommonChars(count, curr);
        }
        return getCommonChars(count);
    }
    
    // 1st helper function:
    private static int[] getCount(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    // 2nd helper function:
    private static void compareCommonChars(int[] count, int[] curr) {
        for (int j = 0; j < 26; j++) {
            if (curr[j] < count[j])
                count[j] = curr[j];
        }
    }

    // 3rd helper function:
    private static List<String> getCommonChars(int[] count) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add((char)('a' + i) + "");     // "" is a MUST to guarantee a string
            }
        }
        return result;
    }
}