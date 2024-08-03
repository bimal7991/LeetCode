class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> hs=new HashSet<String>(wordDict); 
       int dp[]=new int[s.length()+1];
       Arrays.fill(dp,-1);
       return helper(0,s,hs,dp);    
    }
    boolean helper(int i,String s, HashSet<String> hs,int dp[]){
        if(i==s.length())
            return true;
        if(dp[i]!=-1)
            return dp[i]==1?true:false;
        String temp="";
            for(int j=i;j<s.length();j++){
                temp=temp+s.charAt(j);
                if(hs.contains(temp)){
                    if(helper(j+1,s,hs,dp)){
                        dp[i]=1;
                        return true;
                    }
                }
            }
        dp[i]=0;
        return false;
    }
    
}