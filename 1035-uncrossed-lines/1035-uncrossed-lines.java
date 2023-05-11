class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return LCS(nums1,nums2);
    }
    int LCS(int a[], int b[]){
        int n=a.length;
        int m=b.length;
        int dp[][]=new int[n+1][m+1];
        int current=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){      
                if(a[i-1]==b[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                
                  
                
            }
        }
        return dp[n][m];
    }
}