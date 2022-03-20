class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return new int[][]{};
        
        if (image[sr][sc] == newColor)
            return image;
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || 
            image[sr][sc] != color)
            return;
        
        image[sr][sc] = newColor;
        
        dfs(image, sr+1, sc, color, newColor);
        dfs(image, sr-1, sc, color, newColor);
        dfs(image, sr, sc+1, color, newColor);
        dfs(image, sr, sc-1, color, newColor);
    }
}