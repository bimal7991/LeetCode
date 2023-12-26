class Solution {
    static int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
     
        int dp[][]=new int[n+1][target+1];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        return helper(n,k,target,dp);
        
    }
    int helper(int n,int k,int target,int dp[][]){
        if(n==0 && target==0)
            return 1;
        if(n!=0 && target==0)
            return 0;
        
        if(n==0 && target!=0)
            return 0;
        if(target<0)
            return 0;
        
        if(dp[n][target]!=-1)
            return dp[n][target];
            
            
        long count=0;
        
        for(int i=1;i<=k;i++){
            target=target-i;
            count=(count+helper(n-1,k,target,dp)%mod)%mod;
            target=target+i;
            
           
        }
        return dp[n][target]=(int)count;
    }
}