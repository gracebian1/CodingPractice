class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(result, curr, target, candidates, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> curr, int target, int[] candidates, int start){
        if (target > 0){
            for (int i = start; i < candidates.length; i++){
                curr.add(candidates[i]);
                helper(result, curr, target-candidates[i], candidates, i);
                curr.remove(curr.size()-1);
            }
        }
        if (target == 0)
            result.add(new ArrayList<Integer>(curr));
    }
}