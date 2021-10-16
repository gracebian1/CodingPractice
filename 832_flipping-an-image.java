class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        // flip, then invert: [1,1,0] --> [0,1,1] --> [1,0,0]
        // When the 1st and 3rd elements differ, they ended up being the same as original
        // Only need to handle the case when they are the same at the beginning
        
        for (int i = 0; i < image.length; i++) {
            // Index for each row
            int start = 0, end = image[0].length - 1;
            
            while (start <= end) {
                // Only handle the case when two elements are different
                
                if (image[i][start] == image[i][end]) {
                    image[i][start] = 1 - image[i][start];
                    image[i][end] = image[i][start];
                }
                start++;
                end--;
            }
        }
        return image;
    }
}