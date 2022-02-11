class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null && str2 == null)
            return null;
        
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return "";
        
        int len1 = str1.length(), len2 = str2.length();
        int gcd = getGCD(len1, len2);
        
        String totalStr = str1 + str2;
        String gcdStr = str1.substring(0, gcd);
        
        for (int i = 0; i < len1 + len2; i += gcd) {
            if (!totalStr.startsWith(gcdStr, i))
                return "";
        }
        return gcdStr;
    }
    
    private int getGCD(int a, int b) {
        return a == 0 ? b : getGCD(b % a, a);
    }
}