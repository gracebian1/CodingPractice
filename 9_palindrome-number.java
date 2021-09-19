class Solution {
    public boolean isPalindrome(int x) {
        // negative numbers do not fit
        if (x < 0) return false;
        // single digit numbers fit
        if (x / 10 == 0) return true;
        
        int a = x, newX = 0;
        while(a > 0){
            // reverse the original number digit by digit
            newX = newX * 10 + a % 10;
            a = a / 10;
        }   
        return newX == x;
    }
}