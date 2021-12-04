class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Check if DAG (could be topologically sorted)
        // Map key: starting node; Map value: adjacency list
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        
        // Put node and its adjacency list into map
        for (int i = 0; i < prerequisites.length; i++) {
            if (!edgeMap.containsKey(prerequisites[i][0]))
                edgeMap.put(prerequisites[i][0], new ArrayList<>());
            
            edgeMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        boolean[] memo = new boolean[numCourses];
        
        // Call dfs on each course recursively
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edgeMap, visitedSet, memo, list, i)) 
                return new int[0];
        }
        
        // Result array
        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private static boolean dfs(Map<Integer, List<Integer>> edgeMap, Set<Integer> visitedSet, boolean[] memo, List<Integer> list, int n) {
        // Set contains node indicating a cycle
        if (visitedSet.contains(n)) return false;
        
        // Fully explored node
        if (memo[n]) return true;
        
        visitedSet.add(n);
        
        if (edgeMap.get(n) != null) {
            for (int i: edgeMap.get(n)) {
                if (!dfs(edgeMap, visitedSet, memo, list, i))
                    return false;
            }
        }
        // Remove node of CURRENT time's traversal, to let further traversal of same node possible
        visitedSet.remove(n);
        
        memo[n] = true;
        
        // Add node to arraylist
        list.add(n);
        return true;
    }
}