class Solution {
    public String reverseVowels(String s) {
        if (s.length() == 1) return s;
        
        final String vowels = "aeiouAEIOU";
        
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        
        while (start < end) {
            while ((start < end) && vowels.indexOf(arr[start]) == -1) {
                start++;
            }
            while ((start < end) && vowels.indexOf(arr[end]) == -1) {
                end--;
            }
            
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }   
}