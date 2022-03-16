class Solution {
    // BFS: Time: O(m*n); Space: O(m*n)
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        if (rooms == null || m == 0 || n == 0)
            return;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Put all 'gate' in queue
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0)
                    queue.offer(new int[]{row, col});
            }
        }
        // 4 Directions, BFS
        int[][] shifts = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            
            for (int[] shift: shifts) {
                int newR = cell[0] + shift[0];
                int newC = cell[1] + shift[1];
                
                if (newR < 0 || newR >= m || newC < 0 || newC >= n || rooms[newR][newC] != Integer.MAX_VALUE)
                    continue;
                
                // Update distance by 1
                rooms[newR][newC] = rooms[cell[0]][cell[1]] + 1;
                
                // Add new available cells to queue
                queue.offer(new int[]{newR, newC});
            }
        }
    }  
    /*
    // DFS:
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        if (rooms == null || m == 0 || n == 0)
            return;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0)
                    dfs(rooms, row, col, 0);
            }
        }
    }
    
    private void dfs(int[][] rooms, int row, int col, int distance) {
        int m = rooms.length, n = rooms[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || rooms[row][col] < distance)
            return;
        
        rooms[row][col] = distance;
        
        dfs(rooms, row, col + 1, distance + 1);
        dfs(rooms, row, col - 1, distance + 1);
        dfs(rooms, row + 1, col, distance + 1);
        dfs(rooms, row - 1, col, distance + 1);
    }
    */
}