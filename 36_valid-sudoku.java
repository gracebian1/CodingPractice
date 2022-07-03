class Solution {
    // Time, Space: O(N^2) --> N = 9, so O(1)
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        
        int N = 9;
        
        Set<Character>[] rowSet = new HashSet[N];
        Set<Character>[] colSet = new HashSet[N];
        Set<Character>[] boxSet = new HashSet[N];
        
        for (int i = 0; i < N; i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            boxSet[i] = new HashSet<Character>();
        }
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                char val = board[row][col];
                
                if (val == '.')
                    continue;
                
                if (rowSet[row].contains(val))
                    return false;
                rowSet[row].add(val);
                
                if(colSet[col].contains(val))
                    return false;
                colSet[col].add(val);
                
                int boxPos = (row / 3 * 3) + col / 3;
                
                if (boxSet[boxPos].contains(val))
                    return false;
                boxSet[boxPos].add(val);
            }
        }
        return true;
    }
}