class Solution:
#     Time: O(len1 + 26*(len2 - len1)); Space: O(1)

    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        bucket1 = [0] * 26
        bucket2 = [0] * 26
        
        for char in s1:
            bucket1[ord(char) - ord('a')] += 1
            
        for i in range(len(s2)):
            bucket2[ord(s2[i]) - ord('a')] += 1
            
            if i >= len(s1):
                char_to_be_removed = s2[i - len(s1)]
                bucket2[ord(char_to_be_removed) - ord('a')] -= 1
                
            if bucket1 == bucket2:
                return True
        return False