class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        
        int count = 0;
        
        // Boolean array to check visited condition
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    // Call dfs to check four directions
                    dfs(grid, visited, row, col);
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 ||
            visited[row][col] || grid[row][col] == '0') {
            return;
        }
        // Mark the new grid as visited
        visited[row][col] = true;
        
        // Check the four directions of current grid 
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row, col - 1);
    }
}