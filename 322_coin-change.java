class Solution {
    // Dynamic programming: Bottom up
    // Time: O(amount*len of array); Space: O(amount)
    
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        // Dp Array value: number of coins 
        // Dp Array index: amount of money
        
        for(int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coinValue = coins[j];
                
                if (coinValue <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coinValue] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];   
    }
}