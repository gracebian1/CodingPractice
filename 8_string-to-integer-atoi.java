class Solution {
    // ASCII to Integer:
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // Initial index to move forward
        int i = 0;
        
        // Initialize sign
        int sign = 1;
        
        // Final result
        int result = 0;
        
        // while there's leading space, move forward
        while(i < s.length() && s.charAt(i) == ' ')
            i++;
        
        // Decide the sign 
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            
            // If the current result > MAX/10, the result cannot * 10 anymore
            if(result > Integer.MAX_VALUE / 10 ||
               // If the current digit is larger than the mod value, also could cause overflow
                   (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)){
                // Return immediately
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // Keep going
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }
        return result * sign; 
    }
}