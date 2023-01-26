class Solution {
    public int numDecodings(String s) {
      if(s.length()==0)
          return 0;
        
        int n=s.length();
       int dp[]=new int[n+1];
       dp[0]=1;
        dp[1]=s.charAt(0)!='0' ?1:0;
        for(int i=2;i<=n;i++){
            Integer a=Integer.valueOf(s.substring(i-1,i));
            Integer b=Integer.valueOf(s.substring(i-2,i));
            if(a>=1 && a<=9){
             dp[i]+=dp[i-1];
            }
            if(b>=10 && b<=26)
                dp[i]+=dp[i-2];
            
            
        }
        return dp[n];
        
    }
}