class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return compute(nums,target,0,0);
    }
    int compute(int nums[],int target, int i,int sum){
        if(i==nums.length && sum==target){
            return 1;
        }
        if(i>=nums.length){
            return 0;
        }
        int add=compute(nums,target,i+1,sum+nums[i]);
        int sub=compute(nums,target,i+1,sum-nums[i]);
        return add+sub;
    }
}