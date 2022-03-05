class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        if (points == null || points.length == 0 || points[0].length == 0)
            return result;
        
        // Max heap, peek() to get the current largest element, and poll off
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < points.length; i++) {
            // Entry: squared distance + index
            int[] entry = {squaredDistance(points[i]), i};
            
            if (maxHeap.size() < k) {
                maxHeap.add(entry);
            } else if (entry[0] < maxHeap.peek()[0]) {
                maxHeap.poll();
                maxHeap.add(entry);
            }
        }
        
        for (int i = 0; i < k; i++) {
            int index = maxHeap.poll()[1];
            result[i] = points[index];
        }
        return result;    
    }
    
    private static int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}