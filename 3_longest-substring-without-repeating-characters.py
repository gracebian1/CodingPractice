class Solution:
#     Time: O(n), Space: O(min(n,m)): n(size of string), m(size of set)

    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        
        seen: Dict[char, int] = {}
        start: int = 0
        max_len: int = 0
        
        for i, char in enumerate(s):
            if char in seen and start <= seen[char]:
                start = seen[char] + 1
            else:
                max_len = max(max_len, i - start + 1)
            
            seen[char] = i
        
        return max_len