import java.util.Random;

class Solution {
    /*
    // Time: O(nlogk), Space: O(k)
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int n: nums) {
            heap.offer(n);
            
            if (heap.size() > k) {
                heap.poll();
            } 
        }
        return heap.peek();
    }
    */
    /*
    // Quickselect: Time: O(n) (worse case n^2); Space: O(1)
    // AVERAGE Time:O(n):pivot at middle,iterate once for entire n, then half, half...
    // So: n + n/2 + n/4+.... = 2n = O(n)
    // WORSE case: pivot is the largest and at the very beginning of array, 
    // so each time only exclude one number, so about n^2 worse case time.
    
     public int findKthLargest(int[] nums, int k) { 
         int start = 0, end = nums.length - 1, index = nums.length - k;
         
         while (start < end) {
             int pivot = partition(nums, start, end);
             
             if (pivot < index)
                 start = pivot + 1;
             else if (pivot > index) 
                 end = pivot - 1;
             else
                 return nums[pivot];
         }
         return nums[start];
     }
     
     private static int partition(int[] nums, int start, int end) {
         int pivot = start;
         
         while (start <= end) {
             while (start <= end && nums[start] <= nums[pivot])
                 start++;
             while (start <= end && nums[end] > nums[pivot])
                 end--;
             
             if (start > end)
                 break;
             swap(nums, start, end);
         }
         swap(nums, pivot, end);
         return end;
     }
     
     private static void swap(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
     }
     */
    
    // Quickselect in 'Solution'
    // Time: O(n) average, O(n^2) worst; Space: O(1)
    
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        // kth largest is the NEXT AFTER (n-k)th smallest
        return quickselect(0, nums.length - 1, nums.length - k);
    }

    // Return k-th smallest of list from start to end
    public int quickselect(int start, int end, int kSmallest) {
        if (start == end) {
            return this.nums[start];
        }

        // Get random pivot
        Random random = new Random();
        int pivotIndex = start + random.nextInt(end - start);

        pivotIndex = partition(start, end, pivotIndex);

        if (kSmallest == pivotIndex) {
            return this.nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickselect(start, pivotIndex - 1, kSmallest);
        } else {
            return quickselect(pivotIndex + 1, end, kSmallest);
        }
    }

    public int partition(int start, int end, int pivotIndex) {
        int pivot = this.nums[pivotIndex];

        // 1. move pivot to the end
        swap(pivotIndex, end);
        int pivotFinalIndex = start;

        // 2. move all smaller to the left
        for (int i = start; i <= end; i++) {
            if (this.nums[i] < pivot) {
                swap(pivotFinalIndex, i);
                pivotFinalIndex++;
            }
        }

        // 3. move pivot to its final place
        swap(pivotFinalIndex, end);

        return pivotFinalIndex;
    }

    public void swap(int i, int j) {
        int temp = this.nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = temp;
    }
}