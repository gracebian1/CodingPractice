class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);
            
            // Consider case of non letter
            if (!Character.isLetterOrDigit(charStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(charEnd)) {
                end--;
            } else if (Character.toLowerCase(charStart) == Character.toLowerCase(charEnd)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}