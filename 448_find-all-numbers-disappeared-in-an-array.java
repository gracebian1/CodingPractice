class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
            // Attention: HERE use 'while' instead of 'if'
            // Check 1) if number at current index == i + 1
            // and 2) if current number is at the correct position
            
            // If NOT at the correct pos, swap nums[i] with the num which at pos it's supposed to be
            
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];    // nums[nums[i]-1] won't work! Exceed time limit.
                nums[temp - 1] = temp;
            }
        }
        
        // Check the roughly ordered list, find out any that's not num[i] == i + 1
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                list.add(i + 1);
        }
        return list;
    }
}