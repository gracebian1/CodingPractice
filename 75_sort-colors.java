/*
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null) return;
        int p1 = 0, p2 = nums.length - 1, curr = 0;
        
        while (curr <= p2){
            if (nums[curr] == 0){
                swap(nums, curr, p1);
                p1++;
                curr++;
            }
            else if (nums[curr] == 2){
                swap(nums, curr, p2);
                p2--;
            }else{
                curr++;
            }
        }
    }
    
    private void swap(int[] nums, int p1, int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
*/

//solution 2:
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null) return;
        int p1 = 0, p2 = nums.length-1, curr = 0;
        
        while (curr <= p2){
            if (nums[curr] == 0){
                nums[curr] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            else if (nums[curr] == 2){
                nums[curr] = nums[p2];
                nums[p2] = 2;
                curr--;
                p2--;
            }
            curr++;
        }
    }
}
      