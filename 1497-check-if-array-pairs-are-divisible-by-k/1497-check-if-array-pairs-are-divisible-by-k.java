class Solution {
    public boolean canArrange(int[] arr, int k) {
        int dp[]=new int[k];
        for(int i:arr){
            int n=i%k;
            if(n<0)
                n=(n+k)%k;
           dp[n]++;
        }
       for(int i=0;i<k;i++){
           if(i==0){
               if(dp[i]%2!=0)
                   return false;
           }else{
               if(dp[i]!=dp[k-i])
                   return false;
           }
       }
        return true;
    }
}