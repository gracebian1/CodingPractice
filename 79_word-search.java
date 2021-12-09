class Solution {
    // See also 200
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 
            || board[0].length == 0 || word.length() == 0)
            return false;
        
        int m = board.length, n = board[0].length; 
        boolean[][] visited = new boolean[m][n];
        
        for (int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(dfs(board, word, visited, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Backtracking 
    private static boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int curr) {
        // current index in string 
        if (curr == word.length())
            return true;
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        
        if (visited[row][col] || word.charAt(curr) != board[row][col])
            return false;
        
        visited[row][col] = true;
        
        boolean result = dfs(board, word, visited, row, col+1, curr+1) || 
                        dfs(board, word, visited, row, col-1, curr+1) || 
                        dfs(board, word, visited, row+1, col, curr+1) || 
                        dfs(board, word, visited, row-1, col, curr+1);
        
        visited[row][col] = false;
        return result;
    }
}