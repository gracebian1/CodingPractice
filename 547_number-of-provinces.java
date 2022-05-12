class Solution {
    /*
    // DFS: Time: O(n^2), Space: O(n)
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0)
            return 0;
        
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
    */
    /*
    // Union find w/o path compression: O(n^3)
    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return parent[i];
        else
            return find(parent, parent[i]);
    }
    
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
    */
    //Union find with path compression: O(n^2)
    
    private int find(int[]parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return parent[i];
    }
    
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
}