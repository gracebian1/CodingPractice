class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort in ascending order by the first number 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Use linked list to easily attach or merge to the tail
        LinkedList<int[]> temp = new LinkedList<>();
        
        for (int[] interval: intervals) {
            
            // If list is empty, OR the last node's ending num < upcoming element's starting num
            // Indicating non-overlapping, simply add the new element
            
            if (temp.isEmpty() || temp.getLast()[1] < interval[0]) {
                temp.add(interval);
                
            // Else, update the ending num of the linked list            
            } else {
                temp.getLast()[1] = Math.max(temp.getLast()[1], interval[1]);
            }
        }
        // Return the linked list in array
        return temp.toArray(new int[temp.size()][]);
    }
}