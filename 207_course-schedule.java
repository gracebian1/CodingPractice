public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0)
            return true;
        
        // Check if DAG (could be topologically sorted)
        // Map key: starting node; Map value: adjacency list (prerequisites)
        
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            // Build new pair in map
            if (!edgeMap.containsKey(prerequisites[i][0]))
                edgeMap.put(prerequisites[i][0], new ArrayList<>());
            
            // Add new prerequisite course to adjacency list
            edgeMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        // Set of nodes been visited
        Set<Integer> visitedSet = new HashSet<>();
        
        // Boolean array of nodes been fully explored
        boolean[] memo = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edgeMap, visitedSet, memo, i))
                return false;
        }
        return true;
    }
    
    private static boolean dfs(Map<Integer, List<Integer>> edgeMap, Set<Integer> visitedSet, boolean[]memo, int n) {
        // Set already contains node, indicating a cycle
        if (visitedSet.contains(n)) return false;
        
        // Memo node is true, indicating previously fully explored (save cache)
        if (memo[n]) return true;
        
        visitedSet.add(n);
        
        // Call each node in list recursively
        if (edgeMap.get(n) != null) {
            for (int i: edgeMap.get(n)) {
                if (!dfs(edgeMap, visitedSet, memo, i))
                    return false;
            }
        }
        // Remove node for CURRENT TIME's traversal
        // In order to explore the next step for the same node if possible
        visitedSet.remove(n);
        
        // Update memo array to save cache
        memo[n] = true;
        
        return true;
    }
}