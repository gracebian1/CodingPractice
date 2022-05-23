class Solution {
    // With path compression, time for "find" is much less than N (nearly constant), can be ignored.
    // Time: O(N); Space: O(N)    
    
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0)
            return true;
        if (n < 1 || edges == null || edges.length != n - 1) 
            return false;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!union(parent, n1, n2)) {
                return false;
            }
        }
        return true;
    }
    
    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    
    private boolean union(int[] parent, int n1, int n2) {
        int n1set = find(parent, n1);
        int n2set = find(parent, n2);
        
        if (n1set == n2set) {
            return false;
        }
        
        parent[n1set] = n2set;
        return true;
    }

    /*
    // BFS: Time: O(N+E), Space: O(N+E)  
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0)
            return true;
        if (n < 1 || edges == null || edges.length != n - 1) 
            return false;

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for (int[] edge : edges) {
            adjacencyList.putIfAbsent(edge[0], new ArrayList<>());
            adjacencyList.get(edge[0]).add(edge[1]);
            
            // Undirected edge: add twice (two directions)
            
            adjacencyList.putIfAbsent(edge[1], new ArrayList<>());
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        // Add whichever the first node
        queue.offer(edges[0][0]);
        visited.add(edges[0][0]);

        while (!queue.isEmpty()) {
            int nodeVal = queue.poll();
            
            if (adjacencyList.containsKey(nodeVal)) {
                for (int neighborVal: adjacencyList.get(nodeVal)) {
                    if (visited.contains(neighborVal)) 
                        continue;

                    visited.add(neighborVal);
                    queue.offer(neighborVal);
                }
            }
        }
        // This can only check if there's isolated node (not connected to others)
        return visited.size() == n;   
    }
    */
}