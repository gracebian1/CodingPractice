class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x / 10 == 0) return true;       // single digit number 
        
        int reverse = 0;
        int dummy = x;
        
        while (dummy != 0) {
            int tail = dummy % 10;
            int newX = reverse * 10 + tail;
            
            // Check for possible overflow
            if ((newX - tail) / 10 != reverse) return false;
            
            reverse = newX;
            dummy = dummy / 10;
        }
        return (x == reverse);
    }
}