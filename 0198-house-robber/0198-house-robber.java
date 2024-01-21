class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        if(nums.length==1)
            return dp[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        
        return dp[nums.length-1];
    }
    int helper(int nums[],int i,int dp[]){
        if(i>=nums.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int in=nums[i]+helper(nums,i+2,dp);
        int ex=helper(nums,i+1,dp);
        return dp[i]=Math.max(in,ex);
        
    }
}