class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.length() == 1 && s.charAt(0) == '0')
            return 0;
        
        int[] dp = new int[s.length() + 1];
        // Empty string has only 1 way to be decoded: empty string
        dp[0] = 1;
        
        // Only 1 way to decode single digit, unless its previous is '0'
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i < dp.length; i++) {
            // Decode single digit 
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1]; 
            
            // Decode two digits
            // Get the value of two digits i-2 and i-1
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}