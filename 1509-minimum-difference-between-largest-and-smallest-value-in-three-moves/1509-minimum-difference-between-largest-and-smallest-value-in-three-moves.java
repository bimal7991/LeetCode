class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4)
            return 0;
         Arrays.sort(nums);
        int n=nums.length;
         int a=Math.min(nums[n-4]-nums[0],nums[n-1]-nums[3]);
         int b=Math.min(nums[n-3]-nums[1],nums[n-2]-nums[2]);
        return Math.min(a,b);
    }
}