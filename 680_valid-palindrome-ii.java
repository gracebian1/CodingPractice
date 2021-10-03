class Solution {
    /*
    // Without helper function:
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        
        // Not consider case of non letter
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start > end) return true;
        
        // Try newStart and newEnd, once at a time:
        // newStart -> end, start -> newEnd
        int newStart = start + 1, newEnd = end - 1;
        while (newStart <= end && s.charAt(newStart) == s.charAt(end)) {
            newStart++;
            end--;
        }
        if (newStart > end) return true;
        
        while (start <= newEnd && s.charAt(start) == s.charAt(newEnd)) {
            start++;
            newEnd--;
        }
        if (start > newEnd) return true;
        
        return false;
    }
    */

    // With helper function:
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        int start = 0, end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return helper(s, start + 1, end) || helper(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }
    
    private boolean helper(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
    