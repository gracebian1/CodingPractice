class Solution {
    /*
    // Two pointers + charArray:
    public String reverseWords(String s) {
        if (s.length() == 1) return s;
        
        char[] arr = s.toCharArray();
        int i = 0, j = 0;          // two pointers
        
        while (j < arr.length) {
            // j at the end position
            if (j == arr.length - 1) {
                reverse(arr, i, j);
            } 
            if (arr[j] != ' ') {
                j++;
            } else {
                reverse(arr, i, j-1);
                j = j + 1;
                i = j;
            }
        }
        return String.valueOf(arr);
    }
    
    // helper function => BETTER USE STATIC
    private static void reverse(char[] a, int start, int end) {
        while (start < end) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    */
    
    // StringBuilder: 
     public String reverseWords(String s) {
        if (s.length() == 1) return s;
        
        // switch to => array of strings
        String words[] = s.split(" ");
        
        // only one word in s 
        if (words.length == 1) return reverse(words[0]);
        
        StringBuilder result = new StringBuilder();
        
        // loop till the second last word
        for (int i = 0; i < words.length - 1; i++) {
            result.append(reverse(words[i]));
            result.append(" ");             // append space after each word EXCEPT last one
        }
        
        // last string of words
        String lastStr = words[words.length - 1];
        result.append(reverse(lastStr));
        
        return result.toString();
    }
    
    // helper function => USE STATIC
    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            sb.insert(0, str.charAt(i));         // insert each char at index 0
        }
        return sb.toString();
    }
}