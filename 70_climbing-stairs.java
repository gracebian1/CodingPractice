class Solution {
    public int climbStairs(int n) {
        // with memory array
        if(n == 0 || n == 1) return 1;
        
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        
        for(int i = 2; i <= n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
        

 /*    //without memory array
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for (int i = 2; i < n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
   */   
        
    }
}