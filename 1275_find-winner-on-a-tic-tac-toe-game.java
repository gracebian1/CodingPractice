class Solution {
    // Time: O(m * n): m: len of moves; n : len of board
    // Space: O(n * n)
    
    private int N = 3;
    private int[][] board;
    
    public String tictactoe(int[][] moves) {
        if (moves == null || moves.length == 0 || moves[0].length == 0)
            return null;
        
        // Build an empty board
        board = new int[N][N];
        
        // Initialize player 
        int player = 1;
        
        for (int[] move: moves) {
            int row = move[0];
            int col = move[1];
            
            // Place player's move on board
            board[row][col] = player;
            
            if (checkRow(row, player) || checkCol(col, player) ||
               (row == col && checkDiagonal(player)) || 
               (row + col == N - 1 && checkAntiDiagonal(player))) {
                return player == 1 ? "A" : "B";
            }
            // Toggle player 
            player *= -1;
        }
        return moves.length == N * N ? "Draw" : "Pending";
    }
    
    private boolean checkRow(int row, int player) {
        for (int col = 0; col < N; col++) {
            if (board[row][col] != player)
                return false;
        }
        return true;
    }
    
    private boolean checkCol(int col, int player) {
        for (int row = 0; row < N; row++) {
            if (board[row][col] != player)
                return false;
        }
        return true;
    }
    
    private boolean checkDiagonal(int player) {
        for (int row = 0; row < N; row++) {
            if (board[row][row] != player)
                return false;
        }
        return true;
    }
    
    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < N; row++) {
            if (board[row][N - 1 - row] != player)
                return false;
        }
        return true;
    }
}