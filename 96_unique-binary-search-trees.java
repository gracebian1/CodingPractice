/**
 * Taking 1~n as root respectively:
 *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
 *      2 as root: # of trees = F(1) * F(n-2) 
 *      3 as root: # of trees = F(2) * F(n-3)
 *      ...
 *      n-1 as root: # of trees = F(n-2) * F(1)
 *      n as root:   # of trees = F(n-1) * F(0)
 *
 * So, the formulation is:
 *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
 */

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int level = 2; level <= n; level++){
            for (int root = 1; root <= level; root++){
                dp[level] += dp[root-1] * dp[level-root];
            }
        }
        return dp[n];
    }
}

// dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14
// pick a root node, then how many left sub trees and right sub trees can be held under that node, finally multiply them.

//To build a tree contains {1,2,3,4,5}. First pick 1 as root, for the left sub tree, there are none; for the right sub tree, count how many trees are there constructed from {2,3,4,5}, it's the same number as {1,2,3,4}. 
//So the total number of trees under root "1" is dp[0] * dp[4] = 14. (assume dp[0] =1). Similarly, root 2 has dp[1]*dp[3] = 5 trees. root 3 has dp[2]*dp[2] = 4, root 4 has dp[3]*dp[1]= 5, and root 5 has dp[0]*dp[4] = 14. Finally sum the up and done.