class Solution {
    public int[][] transpose(int[][] matrix) {
        // See 48 also. 48 is for n*n square.
        // This one also works for different lengths of row and col.
        
        int m = matrix.length, n = matrix[0].length;
        
        // Swap the length for row and col 
        int[][] result = new int[n][m];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // Swap row and col
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }
}