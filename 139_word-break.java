class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0)
            return false;
        
        // Put all words into a set
        Set<String> wordDictSet = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] is null
        dp[0] = true;
        
        // Attention to i's ending position
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                
                // dp[j]: starting point of a word
                // check both starting and ending points
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    
                    // if a word found, mark one step beyond ending as true
                    // i is next word's starting point
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}