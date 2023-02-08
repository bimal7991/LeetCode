class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        return helper(nums,0,dp);
    }
    int helper(int nums[],int ind,int dp[]){
        if(ind>=nums.length-1 )
            return 0;
        if(nums[ind]==0)
            return nums.length;
        if(dp[ind]!=0)
            return dp[ind];
        int temp=nums.length;
        for(int i=1;i<=nums[ind] ;i++){
            temp=Math.min(temp,1+helper(nums,i+ind,dp));
        }
        
        return dp[ind]=temp;
    }
}