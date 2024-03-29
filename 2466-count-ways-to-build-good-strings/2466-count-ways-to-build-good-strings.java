class Solution {
    int ans=0;
   public int countGoodStrings(int low, int high, int zero, int one) {
      int total=0;
       int dp[]=new int[high+1];
       Arrays.fill(dp,-1);
        for(int len=low;len<=high;len++){
            total=(total+healper(len,zero,one,dp))%1000000007;
        }
        return total;
    }
    public int healper(int n,int zero,int one,int dp[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        } 
        //kaam 
        int way1=healper(n-zero,zero,one,dp)%1000000007;
        int way2=healper(n-one,zero,one,dp)%1000000007;
        return dp[n]=(way1+way2)%1000000007;
    }
}