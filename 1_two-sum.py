class Solution:
# Time: O(n), Space: O(n)

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashmap:
                return [i, hashmap[complement]]
            key = nums[i]
            hashmap[key] = i