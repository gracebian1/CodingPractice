class Solution:
    # Time: O(logn), Space: O(1)
    def search(self, nums: List[int], target: int) -> int:
        if not nums or len(nums) == 0 or (len(nums) == 1 and target != nums[0]):
            return -1
        
        if len(nums) == 1 and target == nums[0]:
            return 0
        
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if target == nums[mid]:
                return mid

            elif nums[left] <= nums[mid]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
                    
            else:
                if target > nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1