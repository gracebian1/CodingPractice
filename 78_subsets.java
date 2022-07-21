class Solution {
    /*
    'Power Set': all possible combinations of all possible lengths, from 0 to n.
    [1,2] equals [2,1] here (no order) so it's not PERMUTATION; it's SUBSET. 
    
    Time: O(n*2^n): for each position of [1,2,3], it has TWO subsets: [] or either[1][2][3].
                    so total NUM of subsets: 2^n; and each subset could be up to LENGTH n,
                    so total time is O(n*2^n)
    Space: O(n)
    */
    
    List<List<Integer>> result = new ArrayList<>();
    int k;
    
    public List<List<Integer>> subsets(int[] nums) {
        for (k = 0; k <= nums.length; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return result;
    }
    
    public void backtrack(int first, ArrayList<Integer> subset, int[] nums) {
        if (subset.size() == k) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        for (int i = first; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(i+1, subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}