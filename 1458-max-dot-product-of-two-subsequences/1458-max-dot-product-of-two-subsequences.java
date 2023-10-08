class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int current=nums1[i]*nums2[j];
                dp[i][j]=current;
                 if(i>0)
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                if(j>0)
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
                
                if(i>0 && j>0)
                    dp[i][j]=Math.max(dp[i-1][j-1]+current,dp[i][j]);
            }
        }
        return dp[n-1][m-1];
    }
}