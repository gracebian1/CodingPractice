class Solution {
    // Time: O(nlogn), Space: O(n)
    public int minMeetingRooms(int[][] intervals) {
        // Sort in ascending order by the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min heap to sort by the ending time 
        // Check for the meeting which ends earlier in order to make room for the next meeting
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        
        for(int[] interval : intervals){
            if(!heap.isEmpty() && heap.peek()[1] <= interval[0]){
                heap.poll();
            }
            heap.add(interval);
        }
        return heap.size();
    }
}