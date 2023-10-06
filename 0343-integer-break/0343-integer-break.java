class Solution {
    public int integerBreak(int a) {
        int dp[]=new int[59];
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        for(int i=5;i<59;i++){
            int max=i%2==0 ? (i/2)*(i/2) : (i/2)*(i/2+1) ;
            for(int j=2;j<i;j++){
                max=Math.max(dp[j]*dp[i-j],max);
                max=Math.max(dp[j]*(i-j),max);
            }
            dp[i]=max;
            
        }
        //System.out.println(Arrays.toString(dp));
        return dp[a];
    }
}