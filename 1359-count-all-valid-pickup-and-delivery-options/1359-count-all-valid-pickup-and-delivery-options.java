class Solution {
    public int countOrders(int n) {
        int mod=1000000007;
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            long m= (2*i*(2*i-1))/2;
            dp[i]= (int)((m*dp[i-1])%mod);
        }
        return dp[n];
    }
}