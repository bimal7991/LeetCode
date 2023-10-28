class Solution {
    public int countVowelPermutation(int n) {
        int mod=1000000007;
        long dp1[]=new long[n+1];
          long dp2[]=new long[n+1];
          long dp3[]=new long[n+1];
          long dp4[]=new long[n+1];
          long dp5[]=new long[n+1];
        dp1[1]=1;dp2[1]=1;dp3[1]=1;dp4[1]=1;dp5[1]=1;
       
        for(int i=2;i<=n;i++){
            dp1[i]=dp2[i-1];
            dp2[i]=(dp1[i-1]+dp3[i-1])%mod;
            dp3[i]=((dp1[i-1]+dp2[i-1])%mod+(dp4[i-1]+dp5[i-1])%mod)%mod;
            dp4[i]=(dp3[i-1]+dp5[i-1])%mod;
            dp5[i]=dp1[i-1];
        }
        
        
        
        return (int)(((dp1[n]+dp2[n])%mod+(dp3[n]+dp5[n])%mod+dp4[n])%mod)%mod;
    }
}