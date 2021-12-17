class Solution {
    public double myPow(double x, int n) {
    // If n = Integer.MIN_VALUE = -2147483648,
    // then -n is supposed to be 2147483648. 
    // But, since Integer.MAX_VALUE is 2147483648-1,
    // 2147483648 will wrap around to -n.
        
    // To avoid the wrong answer for test case x = 2, n = -2147483648,
    // Set n to long
    
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;  
        }
        
        double result = 1;
        double currProduct = x;
        
        while (N > 0) {
            if ((N % 2) == 1) {
                result = result * currProduct;
            }
            currProduct = currProduct * currProduct;
            N /= 2;
        }
        return result;
    }
}