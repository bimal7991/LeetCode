class Solution {
    public int longestStrChain(String[] words) {
         Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int max=0;
        int dp[]=new int[n];
         for(int i=1;i<n;i++){
             for(int j=0;j<i;j++){
                 if(check(words[j],words[i])){
                     // System.out.println(words[j]+" "+words[i]);
                     if(dp[i]<dp[j]+1){
                         dp[i]=dp[j]+1;
                         max=Math.max(max,dp[i]);
                     }
                 }
             }
         }
        return max+1;
    }
    public boolean check(String small,String big){
        if(small.length()+1!=big.length())
            return false;
        int i=0,j=0,diff=0;
        
        while(i<small.length()){
            if(small.charAt(i)==big.charAt(j))
            {
                i++;
                j++;
            }
            else{
                j++;
                diff++;
            }
          if(diff>1)
              return false;
        }
        if(diff<=1)
            return true;
        else
            return false;
    }
}