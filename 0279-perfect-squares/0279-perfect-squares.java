class Solution {
    public int numSquares(int n) {
        int arr[]=new int[1];
        arr[0]=Integer.MAX_VALUE;
        int dp[]=new int[n+1];
        
       return  helper(n,arr,dp);
        
        
        
        
    }
    int helper(int n,int arr[],int dp[])
    {
       if(n<=3)
           return n;
        if(dp[n]!=0)
            return dp[n];
        for(int i=1;i*i<=n;i++){
            arr[0]=Math.min(arr[0],1+helper(n-i*i,arr,dp));
            
        }
       
        return dp[n]=arr[0];
    }
}