class Solution {
    /*
    // Time: O(n), Space: O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        String[] arr = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = arr.length - 1; i > 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[0]);
        
        return sb.toString();
    }
    */

    // Time: O(n), Space: 0(1)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        reverse(arr, 0, len - 1);
        reverseEachWord(arr, len);
        return getFormatted(arr, len);
    }
    
    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
    private static void reverseEachWord(char[] arr, int len) {
        int i = 0, j = 0;
        
        // i: starting of a word; j-1: ending of a word
        while (i < len) {
            while (i < j || i < len && arr[i] == ' ')
                i++;
            while (j < i || j < len && arr[j] != ' ')
                j++;

            reverse(arr, i, j-1);
        }
    }
    
    private static String getFormatted(char[] arr, int len) {
        int i = 0, j = 0;
        
        while (j < len) {
            while (j < len && arr[j] == ' ')
                j++;
            while (j < len && arr[j] != ' ') {
                arr[i] = arr[j];
                i++;
                j++;
            }
            while (j < len && arr[j] == ' ') 
                j++;
            
            // Get one space between words
            if (j < len) {
                arr[i] = ' ';
                i++;
            }
        }
        return String.valueOf(arr).substring(0, i);
    }
}