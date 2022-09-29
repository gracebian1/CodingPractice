class Solution:
#     Time: O(nlogn), Space: O(n)

    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        if len(position) == 1:
            return 1
        
        pair = [[p, s] for p, s in zip(position, speed)]
        stack = []
        
        for p, s in sorted(pair)[::-1]:      # Reverse Sorted Order, slower speed kept
            stack.append((target - p) / s)   # Time to reach target 
            
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
        
        return len(stack)