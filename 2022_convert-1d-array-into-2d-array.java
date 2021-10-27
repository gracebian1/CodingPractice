class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) { 
        int len = original.length;
        if (m * n != len) return new int[0][0];
        
        int[][] result = new int[m][n];
        int row = 0, col = 0;
        
        for (int i = 0; i < len; i++) {
            result[row][col] = original[i];
            
            // Move to the next column 
            col++;
            
            // When reach the end of column, move to the next row
            if (col == n) {
                col = 0;
                row++;
            }
        }
        return result;
    }
}