class Solution {
    public String largestOddNumber(String num) {
        // Iterate from the least significant digit
        
        for (int i = num.length() - 1; i >= 0; i--) {
            // Type conversion
            if ((num.charAt(i) - '0') % 2 != 0)
                
                // substring
                return num.substring(0, i+1);
        }
        return "";
    }
}