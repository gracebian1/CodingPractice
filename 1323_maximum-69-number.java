class Solution {
    public int maximum69Number (int num) {
        
        // Type conversion: Convert to char array of digits
        // Integer --> String --> char array
        
        char[] digits = Integer.toString(num).toCharArray();
        
        // Start from the most significant digit
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        // char array --> String --> Integer
        return Integer.parseInt(String.valueOf(digits)); 
    }
}