class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        int dp[][][]=new int [s3.length()+1][s1.length()+1][s2.length()+1];
        
        return helper(s3,s1,s2,0,0,0,dp);
    }
    
    boolean helper(String s1,String s2,String s3,int i,int j,int k,int dp[][][]){
        if(j==s2.length() && k==s3.length() && i!=s1.length())
            return false;
        
        if(i==s1.length())
            return true;
        if(dp[i][j][k]==1)
            return true;
        if(dp[i][j][k]==2)
            return false;
        boolean ans1=false;
        boolean ans2=false;
        
        if(j<s2.length() &&  s1.charAt(i)==s2.charAt(j)){
            ans1= ans1 || helper(s1,s2,s3,i+1,j+1,k,dp);
        }
        if(k<s3.length() && s1.charAt(i)==s3.charAt(k)){
            ans2=ans2 || helper(s1,s2,s3,i+1,j,k+1,dp);
        }
        
        dp[i][j][k]= (ans1 || ans2)?1:2;
        return ans1 || ans2;
    }
}