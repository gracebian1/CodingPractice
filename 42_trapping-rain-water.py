class Solution:
#     Time: O(n), Space: O(1): sum water in each bin(width is 1)

    def trap(self, height: List[int]) -> int:
        if not height or len(height) == 0:
            return 0
        
        left, right = 0, len(height) - 1
        
        left_max = height[left]
        right_max = height[right]
        
        result = 0
        
        while left < right:
            if height[left] <= height[right]:
                left += 1
                left_max = max(left_max, height[left])
                result += left_max - height[left]
            else:
                right -= 1
                right_max = max(right_max, height[right])
                result += right_max - height[right]
        
        return result