class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][][]=new int[m+1][n+1][n+1];
        for(int d[][]:dp){
            for(int a[]:d)
                Arrays.fill(a,-1);
        }
        return helper(grid,0,0,grid[0].length-1,dp);
    }
  public int helper(int grid[][],int row,int a,int b,int dp[][][]){
        if(a<0 || a>=grid[0].length || b<0 || b>=grid[0].length)
            return 0;
        if(row==grid.length)
            return 0;
      if(dp[row][a][b]!=-1)
          return dp[row][a][b];
        int sum=0;
        sum=sum+grid[row][a];
        sum=sum+grid[row][b];
        int max=0;
        for(int i=a-1;i<=a+1;i++){
            for(int j=b-1;j<=b+1;j++){
                if(i<j)
                max=Math.max(max,helper(grid,row+1,i,j,dp));
            }
        }
        sum=sum+max;
        return dp[row][a][b]=sum;
    }
}