class Solution {
    public int minAddToMakeValid(String s) {
        // number of ( and ) that to be added on both sides
        int left = 0, right = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                right++;
            else if(right > 0)        // make sure minimum number of moves
                right--;
            else
                left++;
        }
        return left + right;
    }
}