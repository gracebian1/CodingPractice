class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return true;
        
        int len = s.length();  
        // Start by dividing s in half
        for (int divisor = len/2; divisor >= 1; divisor--) {
            if (len % divisor == 0) {
                String subStr = s.substring(0, divisor);
                
                int count = len/divisor;    // number of copies of subStr
                
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append(subStr);  
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}