class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> factP=new ArrayList<>();
        for(int f[]:factory){
            for(int i=0;i<f[1];i++)
                factP.add(f[0]);
        }
        Collections.sort(factP);
        Collections.sort(robot);
        long dp[][]=new long[robot.size()][factP.size()];
        for(long d[]:dp)
            Arrays.fill(d,-1);
        return helper(0,0,robot,factP,dp);
    }
    long helper(int r,int f,List<Integer> robot,List<Integer> factory,long dp[][]){
        
        if(r==robot.size())
            return 0;
         if(f==factory.size())
             return 200000000001L;
        if(dp[r][f]!=-1)
            return dp[r][f];
        
        long diff=Math.abs(robot.get(r)-factory.get(f));
        long take=diff+helper(r+1,f+1,robot,factory,dp);
        long notTake=helper(r,f+1,robot,factory,dp);
        return dp[r][f]=Math.min(take,notTake);
    }
}