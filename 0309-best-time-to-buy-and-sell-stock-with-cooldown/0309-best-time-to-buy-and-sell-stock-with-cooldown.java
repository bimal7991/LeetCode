class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)
            return 0;
        int dp[]=new int[n];
        
        int maxDiff=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            
                if(i < 2) 
                    maxDiff = Math.max(maxDiff, -prices[i]);
            
            if(i==0)
                dp[0]=0;
            else if(i==1)
                dp[i]=Math.max(0,prices[i]-prices[0]);
                
            else{
             
                dp[i]=Math.max(maxDiff+prices[i],dp[i-1]);
                maxDiff=Math.max(maxDiff,dp[i-2]-prices[i]);
                
                
                
            }     
        }
        return dp[n-1];
        
     
    }
}