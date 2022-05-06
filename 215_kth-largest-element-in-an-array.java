class Solution {
    /* Heap:
 1): Put the first k elements into the heap. Time complexity O(k). 
 2): From k + 1 to n, compare each one with heap.peek(). If greater than the peek(minimum), replace. Time complexity O((n - k) logk).
 3): The heap stores the top k elements, the kth largest element is the minimum, which is peek().
    Space complexity O(k). 
    */
    /* Time: O(nlogk); Space: O(k) 
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        
        for (int n: nums) {
            heap.offer(n);
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
    */


    // Quick-selection:  similar to quick sort. Only needs partition, to find pivot, compare pivot with k. 
    
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index){
                start = pivot + 1;  
            }else if (pivot > index) {
                end = pivot - 1;
            }else {
                return nums[pivot];
            }
        }
        return nums[start];
    }
    
    private static int partition(int[] nums, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) {
                start++;
            }
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }
            swap(nums, start, end);
        }
        swap(nums, pivot, end);
        return end;
    }

    private static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }    
}