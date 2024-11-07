class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int dp[][][]=new int[prices.length][k][2];
        return helper(prices,0,0,0,0,dp,k);
        
    }
    
    int helper(int prices[],int l,int profit,int index,int flag,int dp[][][],int k){
        
        if(l==k || index==prices.length)
            return 0;
        if(dp[index][l][flag]!=0)
            return dp[index][l][flag];
        
       if(flag==0){
          int a=-prices[index]+helper(prices,l,profit,index+1,1,dp,k);
           int b=helper(prices,l,profit,index+1,0,dp,k);
          dp[index][l][flag]=Math.max(a,b);
           return Math.max(a,b);
       }
        else{
          int a=prices[index]+ helper(prices,l+1,profit,index+1,0,dp,k);
          int b=helper(prices,l,profit,index+1,1,dp,k);
          dp[index][l][flag]=Math.max(a,b);
            return Math.max(a,b);
        }
        
        
        
    }
}