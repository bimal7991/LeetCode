class Solution {
    int max=0;
    public int getMaximumGold(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int vis[][]=new int[grid.length][grid[0].length];
                if(grid[i][j]!=0){
                    helper(0,grid,i,j,vis);
                }
            }
        }
        return max;
    }
   public void helper(int sum,int grid[][],int i,int j,int vis[][]){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]==0 || vis[i][j]==1)
            return;
        sum=sum+grid[i][j];
        max=Math.max(max,sum);
        vis[i][j]=1;
         helper(sum,grid,i+1,j,vis);
         helper(sum,grid,i-1,j,vis);
         helper(sum,grid,i,j+1,vis);
         helper(sum,grid,i,j-1,vis);
        sum=sum-grid[i][j];
        vis[i][j]=0;
        
    }
}