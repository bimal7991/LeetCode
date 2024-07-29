class Solution {
    public int minCut(String s) {
        int dp[][]=new int[s.length()][s.length()];
        for(int d[]:dp)
        {
            Arrays.fill(d,-1);
        }
        return helper(0,0,s,dp);
    }
    public int helper(int i,int j,String s,int dp[][]){
        if(j==s.length())
        {
            if(isPalindrome(i,j-1,s))
                return 0;
            else
                return 20005;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(isPalindrome(i,j,s)){
           int a=1+helper(j+1,j+1,s,dp);
           int b=helper(i,j+1,s,dp);
            return dp[i][j]= Math.min(a,b);
        }
        else{
           return dp[i][j]=helper(i,j+1,s,dp);
        }
    }
    boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}