class Solution {
    public boolean validPartition(int[] nums) {
        
        boolean dp[]=new boolean[nums.length];
        return helper(nums,nums.length-1,dp);
    }
    boolean helper(int[] nums,int i,boolean dp[]){
        if(i<0)
            return true;
        if(dp[i])
            return true;
      boolean ans=false;
        
       if(i-1>=0 && nums[i]==nums[i-1])
          ans=ans || helper(nums,i-2,dp);
        
       if(i-2>=0 && (nums[i]==nums[i-1]+1 && nums[i]==nums[i-2]+2 && nums[i-1]==nums[i-2]+1))
            ans=ans || helper(nums,i-3,dp);
       if(i-2>=0 && (nums[i]==nums[i-1] && nums[i]==nums[i-2]))
            ans=ans || helper(nums,i-3,dp);
        
      return dp[i]=ans;
    }
}