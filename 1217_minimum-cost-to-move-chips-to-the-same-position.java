class Solution {
    public int minCostToMoveChips(int[] position) {
       /** Move all at EVEN positions to position 2-- no cost,
           Move all at ODD positions to position 1 -- no cost,
           Compare position 1 and 2,
           Move the 'less' to the 'more' -->
           Compare the EVEN with the ODD
        **/ 
        
        int even = 0, odd = 0;
        
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        return Math.min(even, odd);
    }
}