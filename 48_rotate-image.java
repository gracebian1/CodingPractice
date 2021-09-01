class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    
    public void transpose(int[][] matrix){
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    
    public void reverse(int[][] matrix){
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
    
    
}
/* Clockwise rotation

   Original            Transposed                Reversed
1  2  3  4  5         1  6  11 16 21         21 16 11  6  1  
6  7  8  9  10        2  7  12 17 22         22 17 12  7  2
11 12 13 14 15    =>  3  8  13 18 23   =>    23 18 13  8  3
16 17 18 19 20        4  9  14 19 24         24 19 14  9  4
21 22 23 24 25        5  10 15 20 25         25 20 15  10 5

*/

/*
    a common method to solve the image rotation problems.
    /*
     * CLOCKWISE rotate
     * first reverse up to down, then swap the symmetry 
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
    */

    /*
     * ANTICLOCKWISE rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
    */