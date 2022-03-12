class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        
        if (b == null || b.length() == 0)
            return a;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            // Each time insert at index 0 (inverse order)
            sb.insert(0, carry % 2);
            
            // Carry gets ready for next round  
            carry /= 2; 
        }
        // If new digit of carry
        if (carry == 1)
            sb.insert(0, 1);
        
        return sb.toString();
    }
}