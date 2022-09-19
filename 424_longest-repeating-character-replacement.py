class Solution:
#     Time: O(n), Space: O(1)

    def characterReplacement(self, s: str, k: int) -> int:
        if not s or len(s) == 0:
            return 0
        
        bucket = [0] * 26
        result = 0
        
        left = 0
        most_freq = 0
        
        for right in range(len(s)):
            char = s[right]
            bucket[ord(char) - ord('A')] += 1
            
            most_freq = max(most_freq, bucket[ord(char) - ord('A')])
            
            window = right - left + 1
            replace = window - most_freq
            
            if replace > k:
                bucket[ord(s[left]) - ord('A')] -= 1
                left += 1
            else:
                result = max(result, window)
        
        return result