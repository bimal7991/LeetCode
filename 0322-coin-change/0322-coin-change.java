class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int d[]:dp)
            Arrays.fill(d,-1);
        int ans=helper(0,coins,amount,dp);
        return ans==99999?-1:ans;
        
    }
    int helper(int i,int coins[],int amount,int dp[][]){
        if(amount==0)
           return 0;
        if(i==coins.length || amount<0)
           return 99999;
        if(dp[i][amount]!=-1)
            return dp[i][amount];
        int inc=1+helper(i,coins,amount-coins[i],dp);
        int exc=helper(i+1,coins,amount,dp);
        return dp[i][amount]=Math.min(inc,exc);
    }
}