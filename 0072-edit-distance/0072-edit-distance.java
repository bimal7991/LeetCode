class Solution {
    public int minDistance(String word1, String word2) {
        // return helper(0,word1,0,word2);
        int n=word1.length(),m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
         for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=1+ Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        
    }
    int helper(int i,String word1,int j,String word2){
        if(i==word1.length())
            return word2.length()-j;
        if(j==word2.length())
            return word1.length()-i;
        
        
        if(word1.charAt(i)!=word2.charAt(j)){
           return 1+ Math.min(Math.min(helper(i+1,word1,j+1,word2),helper(i+1,word1,j,word2)),helper(i,word1,j+1,word2));
        }
        else{
            return helper(i+1,word1,j+1,word2);
        }
    }
}