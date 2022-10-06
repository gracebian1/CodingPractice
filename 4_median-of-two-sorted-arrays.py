class Solution:
    # Time: O(log(m+n)) (Binary search), Space: O(1)
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        total_len = len(nums1) + len(nums2)
        half_len = total_len // 2

        # Make A the shorter array
        if len(B) < len(A):
            A, B = B, A
        
        left, right = 0, len(A) - 1

        while True:
            mid_A = left + (right - left) // 2
            mid_B = half_len - mid_A - 2        # Index starts at 0, so -2

            # Get 4 numbers at both ends for the result(median)
            A_left = A[mid_A] if mid_A >= 0 else float("-infinity")
            B_left = B[mid_B] if mid_B >= 0 else float("-infinity")

            A_right = A[mid_A + 1] if mid_A < len(A) - 1 else float("infinity")
            B_right = B[mid_B + 1] if mid_B < len(B) - 1 else float("infinity")

            # Check if partition is correct: left side should be <= right side
            if A_left <= B_right and B_left <= A_right:
                if total_len % 2 == 0:       # Even length
                    return (max(A_left, B_left) + min(A_right, B_right)) / 2
                else:                        # Odd length
                    return min(A_right, B_right)

            elif A_left > B_right:         # A has larger element on left side
                right = mid_A - 1
            else:                          # B has larger element on left side
                left = mid_A + 1