class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int dp[][]=new int[grid.length+1][grid[0].length+1];
        for(int d[]:dp)
            Arrays.fill(d,-1);
        if(grid[grid.length-1][grid[0].length-1]==1)
            return 0;
      return  helper(grid,0,0,dp);
       
    }
    int  helper(int[][] m,int i,int j,int dp[][]){
        if(i==m.length-1 && j==m[0].length-1){
            return 1;
        }
        if(i>=m.length || j>=m[0].length || m[i][j]==1)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int sum=0;
        if(i+1<m.length && m[i][j]!=-1)
            sum=sum+helper(m,i+1,j,dp);
        if(j+1<m[0].length && m[i][j+1]!=-1)
             sum=sum+helper(m,i,j+1,dp);
        return dp[i][j]=sum;
        
    }
}