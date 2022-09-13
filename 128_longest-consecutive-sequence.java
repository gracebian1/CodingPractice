class Solution {
/* Time: O(n), Space: O(n)
Time is NOT quadratic: it's linear. While loop is reached ONLY WHEN currentNum marks the 
beginning of a sequence, while loop can only run for n iterations. 
So even if looks like O(n*n) complexity, the nested loops actually O(n+n)=O(2n) (linear).
*/
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        
        int len = 0;
        for (int n: nums) {
            if (!set.contains(n - 1)) {
                int currNum = n;
                int currLen = 1;
                
                // Get 'consecutive', use 'while'
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }
                len = Math.max(len, currLen);
            }
        }
        return len;
    }
}