class Solution {
// Time: O(m*n); Space: O(1)
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;   
        int m = board.length, n = board[0].length;
        
        // Positions of neighbor
        // 0: itself; -1: one row up/one col left; 1: one row down/one col right
        int[] shift = {0, -1, 1};
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                
                int liveCells = 0;
                
                // Check the 9 cells of neighbors
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        
                        // Exclude the cell itself
                        if (shift[i] != 0 || shift[j] != 0) {
                            
                            // Get the cell of neighbor
                            int rowOfNeighbor = row + shift[i];
                            int colOfNeighbor = col + shift[j];
                            
                            // Check the state of neighbor
                            // Math.abs() to get the original absolute value of cell    
                            if (rowOfNeighbor >= 0 && rowOfNeighbor < m && colOfNeighbor >= 0 && colOfNeighbor < n && 
                                Math.abs(board[rowOfNeighbor][colOfNeighbor]) == 1)
                                liveCells++;
                        } 
                    }
                }
                // Live cells--> now dead cells
                if ((board[row][col] == 1) && (liveCells < 2 || liveCells > 3))
                    board[row][col] = -1;
                // Dead cells--> now live cells
                if (board[row][col] == 0 && liveCells == 3)
                    board[row][col] = 2;
            }
        }
        // Update the matrix
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                
                // All positive cells
                if (board[row][col] > 0) 
                    board[row][col] = 1;
                // Others, including negative cells and 0 cells
                else
                    board[row][col] = 0;
            }
        }
    }
}