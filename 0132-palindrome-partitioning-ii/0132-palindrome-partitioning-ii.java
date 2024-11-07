class Solution {
    public int minCut(String s) {
    int dp[][]=new int[s.length()][s.length()];
    for(int d[]:dp)
        Arrays.fill(d,-1);
        return helper(0,0,s,dp);
    }
    public int helper(int i,int j,String s,int dp[][]){
         
          if(j==s.length()-1){
               if(isPalindrome(i,j,s))
                 return 0;
              return 200007;
          }
       if(dp[i][j]!=-1)
           return dp[i][j];
        if(isPalindrome(i,j,s)){
            int inc=1+helper(j+1,j+1,s,dp);
            int exc=helper(i,j+1,s,dp);
            return dp[i][j]= Math.min(inc,exc);
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