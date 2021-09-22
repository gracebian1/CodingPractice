class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++){
            List<List<Integer>> currLevel = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                for (List<Integer> l : result){
                    List<Integer> temp = new ArrayList<>(l);
                    temp.add(j, nums[i]);
                    currLevel.add(temp);
                }
            }
            result = currLevel;
        }
        return result;
    }
}