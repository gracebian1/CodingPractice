class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[] flippedCols = new boolean[n];
        
        // Flip all cols with first row having 1
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1 && !flippedCols[col]) {
                flippedCols[col] = true;
                
                // Flip that col
                for (int row = 0; row < m; row++) {
                    grid[row][col] = (grid[row][col] == 1) ? 0 : 1;
                }
            }
        }
        
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n-1; col++) {
                
                // If all are not same, then impossible to achieve the target
                if (grid[row][col] != grid[row][col+1])
                    return false;
            }
        }
        return true;
    }
}