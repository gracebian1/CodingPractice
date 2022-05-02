class Solution {
    // Time: O(nlogn); Space: O(logn)
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{};
        
        if (intervals.length == 1)
            return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> list = new LinkedList<>();
        
        for (int[] interval: intervals) {
            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(interval[1], list.getLast()[1]);
            }
        }
        
        int[][] result = new int[list.size()][];      
        return list.toArray(result);
    }
}