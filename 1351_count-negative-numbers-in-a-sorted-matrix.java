class Solution {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        // Attention: matrix is sorted both row-wise and column-wise
        // start from bottom-left corner
        // If the last row has no negatives, there is no need for further count
        
        int row = grid.length - 1, col = 0;
        int count = 0;
        
        while (row >= 0 && col < grid[0].length) {
            if (grid[row][col] < 0) {
                
                // Sorted grid, once grid[row][col] < 0, elements afterwards also < 0
                count += grid[0].length - col;
                // Move row upwards
                row--;
            } else {
                col++;
            }
        }
        return count;
    }
}