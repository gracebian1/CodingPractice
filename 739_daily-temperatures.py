class Solution:
#     Time: O(n), Space: O(n): Monotonic Stack
#     NOT n^2, because each element added to stack ONLY ONCE
#     Worse case: each element added and popped once, so O(2*n)=O(n)

    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = []
        
        for curr_day, curr_temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < curr_temp:
                prev_day = stack.pop()
                result[prev_day] = curr_day - prev_day
            stack.append(curr_day)
        
        return result