class Solution {
    public String reverseStr(String s, int k) {
        if(s.length() == 1) return s;
        
        char[] arr = s.toCharArray();
        int i = 0;
        
        while(i < arr.length){
            int j = Math.min(i + k - 1, arr.length-1);   // compare the ending index with length-1
            reverse(arr, i, j);    // call helper function
            i = i + 2*k;           // jump to the next 2k
        }
        return String.valueOf(arr);   // get the string representation
    }
    
    private void reverse(char[] a, int start, int end){  
        while(start < end){
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
