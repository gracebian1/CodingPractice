class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        // Add 4 to each island, then subtract 2 for each two islands connected
        // Check for two directions: UP and LEFT
        
        int sum = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    sum += 4;
                    if (row > 0 && grid[row-1][col] == 1) sum -= 2;
                    if (col > 0 && grid[row][col-1] == 1) sum -= 2;
                }
            }
        }
        return sum;       
    }
}