class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long dp[]=new long[n];
        Arrays.fill(dp,-1);
        return helper(0,questions,dp);
    }
   long helper(int index,int[][] q,long dp[]){
        if(index>=q.length)
            return 0;
         if(dp[index]!=-1)
             return dp[index];
        long inc=q[index][0]+helper(index+q[index][1]+1,q,dp);
        long ex=helper(index+1,q,dp);
        return dp[index]=Math.max(inc,ex);
    }
}