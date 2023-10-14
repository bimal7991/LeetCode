class Solution {
    public int paintWalls(int[] cost, int[] time) {
     int dp[][]=new int[501][501];
      return solve(cost,time,0,time.length,dp);
    }
    int solve(int cost[],int time[],int i,int rem,int dp[][]){
        if(rem<=0)
            return 0;
        if(i>=time.length)
            return 1000000007;
        if(dp[i][rem]!=0)
            return dp[i][rem];
        int exclude=solve(cost,time,i+1,rem,dp);
        int include=cost[i]+solve(cost,time,i+1,rem-time[i]-1,dp);
        return dp[i][rem]=Math.min(include,exclude);
    }
}