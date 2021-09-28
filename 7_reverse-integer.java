class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        
        int reverse = 0;
        while (x != 0) {
            int tail = x % 10;      // get the current least significant digit
            int newResult = reverse * 10 + tail;
            
            // check if out of range: 32-bit integer range
            if ((newResult - tail) / 10 != reverse) return 0;
            
            reverse = newResult;
            x = x / 10;            // moving forward
        }
        return sign * reverse;
    }
}