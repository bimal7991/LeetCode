class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> hs=new HashSet<String>(wordDict); 
       boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
       for(int i=1;i<=s.length();i++){
           for(int j=0;j<i;j++){
                if( dp[j] && hs.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
           
       } 
        
        return dp[s.length()];
       // Arrays.fill(dp,-1);
       // return helper(0,s,hs,dp);    
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