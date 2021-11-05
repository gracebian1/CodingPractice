class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        // Starting from the least significant dight
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        // Be prepared for a digit that's transferred to more significant digit
        int carry = 0;
        
        // Loop from the least significant digit
        // ||, not && 
        while (i >= 0 || j >= 0) {
            int sum = carry;
            
            // Attention: subtract char 0, NOT int 0. Convert into ASCII. 
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            
            // Append the mod
            result.append(sum % 10);
            
            // / to get the carry
            carry = sum / 10;
        }
        
        // If carry has number 
        if (carry != 0) {
            result.append(carry);
        }
        
        // Reverse the result, since it has been appended
        return result.reverse().toString();
    }
}