class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int dp[][]=new int[piles.size()+1][k+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return helper(0,piles,dp,k);
        
    }
    int helper(int index,List<List<Integer>> piles,int dp[][],int k){
        if(index>=piles.size() )
            return 0;
        int sum=0;
        int max=0;
        if(dp[index][k]!=-1)
            return dp[index][k];
        
        max=Math.max(max,helper(index+1,piles,dp,k));
        
        for(int i=0;i<piles.get(index).size();i++){
            sum=sum+piles.get(index).get(i);
            if(k-i-1>=0)
            max=Math.max(max,sum+helper(index+1,piles,dp,k-i-1));
        }
        return dp[index][k]=max;
    }
}