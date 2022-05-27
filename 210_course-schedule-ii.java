class Solution {
    // Node in-degree: Time: O(V+E), Space: O(V+E)
    // In-degree 0 --> a vertex with NO incoming edges
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topologicalOrder = new int[numCourses];
        
        // Key: source; Value: list of destination
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        // Key: index of destination; Value: in-degree
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            indegreeMap.put(i, 0);
        }
        
        // Adjacency list to represent the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            
            adjacencyList.putIfAbsent(src, new ArrayList<Integer>());
            adjacencyList.get(src).add(dest);

            // In-degree for each vertex
            indegreeMap.put(dest, indegreeMap.get(dest) + 1);
        }
        
        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeMap.containsKey(i) && indegreeMap.get(i) == 0) {
                queue.add(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            topologicalOrder[i] = course;
            i++;

            // Reduce the in-degree of each neighbor by 1
            if (adjacencyList.containsKey(course)) {
                for (int neighbor: adjacencyList.get(course)) {
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);

                    if (indegreeMap.containsKey(neighbor) && indegreeMap.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[]{};
    }

    /*
    // DFS: Check if DAG (could be topologically sorted)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Key: source; Value: list of destination
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            
            adjacencyList.putIfAbsent(src, new ArrayList<>());
            adjacencyList.get(src).add(dest);
        }
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        boolean[] memo = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacencyList, visitedSet, memo, list, i)) 
                return new int[]{};
        }
        
        int[] topologicalOrder = new int[numCourses];
        int j = list.size() - 1;
         
        for (int i = 0; i < numCourses; i++) {
            topologicalOrder[i] = list.get(j);
            j--;
        }
        return topologicalOrder;
    }
    
    private static boolean dfs(Map<Integer, List<Integer>> adjacencyList, Set<Integer> visitedSet, boolean[] memo, List<Integer> list, int n) {
        // If set already contains node, indicates a cycle
        if (visitedSet.contains(n)) 
            return false;
        
        // Fully explored node (no need to go further beyond)
        if (memo[n]) 
            return true;
        
        visitedSet.add(n);
        
        if (adjacencyList.containsKey(n)) {
            for (int neighbor: adjacencyList.get(n)) {
                if (!dfs(adjacencyList, visitedSet, memo, list, neighbor))
                    return false;
            }
        }
        // Remove node of CURRENT time's traversal, to let further traversal of same node possible
        visitedSet.remove(n);
        
        memo[n] = true;

        list.add(n);
        return true;
    }
    */
}