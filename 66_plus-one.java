class Solution {
    public int[] plusOne(int[] digits) {
        // traverse backwards
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        
        // In case the most significant digit changed to 9: 
        int[] newA = new int[digits.length + 1];
        newA[0] = 1;
        return newA;
    }
}