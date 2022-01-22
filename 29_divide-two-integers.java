class Solution {
    // Time: O(log2n); Space: O(1)
    private static int HALF_INT_MIN = -1073741824;
    
    public int divide(int dividend, int divisor) {
        // Overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        // Convert to negatives due to larger range avoiding overflow
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        
        int quotient = 0;
        
        /* Once divisor is larger than current dividend,
         * can't fit any more copies of divisor into it. */
        while (divisor >= dividend) {
            
            /* Fit at least once as divivend >= divisor.
             * Use a negative powerOfTwo as for divide(INT_MIN, -1). */
            int powerOfTwo = -1;
            int value = divisor;
            
            // Check if double the current value is too big. If not, continue doubling.
            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            
            // Subtract divisor another powerOfTwo times
            quotient += powerOfTwo;
            // Remove value so far, to continue process with remainder.
            dividend -= value;
        }
        
        if (negatives != 1)
            return -quotient;
        
        return quotient;
    }
}