class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        
        // Parameters are impossible to reshape
        if (r * c != m * n) return mat;
        
        int[][] result = new int[r][c];
        int row = 0, col = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[row][col] = mat[i][j];
                
                // Follow the same row-traversing order, move to the next column
                col++;
                // When reach the end of col, start from the next row, col 0
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }
}