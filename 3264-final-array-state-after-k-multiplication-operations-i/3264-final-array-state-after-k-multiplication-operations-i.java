class Solution {
private int helper(int[] nums){
        int min_idx = 0;
        int min = nums[0];
        for(int i=1;i<nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                min_idx=i;
            }
        }
        return min_idx;
    }
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0; i<k; i++){
            int idx = helper(nums);
            nums[idx] *= multiplier;
        }
        return nums;
    }
}