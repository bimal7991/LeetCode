class Solution {
    public int strangePrinter(String s) {
       int n=s.length();
       int dp[][]=new int[n][n];
       for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
       
        return helper(0,n-1,dp,s);
    }
    int helper(int i,int j,int dp[][],String s){
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
     
        int printFast=1+helper(i+1,j,dp,s);
        for(int k=i+1;k<=j;k++){
            if(s.charAt(i)==s.charAt(k)){
                int printWhole=helper(i,k-1,dp,s)+helper(k+1,j,dp,s);
                printFast=Math.min(printFast,printWhole);
            }
        }
        return dp[i][j]= printFast;
        
    }
}