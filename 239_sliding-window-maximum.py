class Solution:
#     Time: O(n), Space: O(n)

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums or len(nums) == 0:
            return []
        
        result = []
        
      # Deque: add/remove from both ends 0(1); here store INDEX   
        dq = collections.deque()
        
        for i in range(len(nums)):
            
      # Remove LEFTMOST index IF out of k range
            if dq and dq[0] < i - k + 1:
                dq.popleft()
            
      # Remove smaller element from RIGHT
            while dq and nums[dq[-1]] < nums[i]:
                dq.pop()
            
            dq.append(i)
            
            if i >= k - 1:
                result.append(nums[dq[0]])
        
        return result