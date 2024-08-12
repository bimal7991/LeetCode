class Solution {
    public int splitArray(int[] nums, int k) {
        // for(int i=1;i<nums.length;i++){
        //     nums[i]=nums[i]+nums[i-1];
        // }
        int dp[][]=new int[nums.length][k+1];
        for(int d[]:dp){
           Arrays.fill(d,-1); 
        }
        int ans=helper(nums,k,0,dp);
        return ans;
    }
    int helper(int nums[],int k,int i,int dp[][]){
        if(i==nums.length && k==0){
            return 0;
        }
        if(i==nums.length || k==0)
            return Integer.MAX_VALUE;
        if(dp[i][k]!=-1)
            return dp[i][k];
        int sum=0;
        int ret=Integer.MAX_VALUE;
        for(int l=i;l<nums.length;l++){
            sum+=nums[l];
            ret=Math.min(ret,Math.max(sum,helper(nums,k-1,l+1,dp)));
        }
        return dp[i][k]=ret;
    }
}