class Solution {
    public int lengthOfLongestSubstring(String s) {
         if (s == null || s.length() == 0){
            return 0;
        } 
        int i = 0, j = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (i < len){
            if (!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}