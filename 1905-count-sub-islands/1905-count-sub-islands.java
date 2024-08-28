class Solution {
    int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
         int m=grid1[0].length;        
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid2[i][j]==1 && dfs(grid1,grid2,i,j)){
                       count++;
               } 
            }
        }
        return count;
        
    }
    boolean dfs(int[][] grid1,int[][] grid2, int i,int j) {
  
    if(i<0 || i==grid2.length || j<0 || j==grid2[0].length || grid2[i][j] == 0 )
    return true;
    
        if(grid1[i][j]==0)
           return false;
        
            grid2[i][j]=0; 
         boolean ans = true;
        // Mark Visited
        for(int k=0;k<dir.length;k++){
           int row=i+dir[k][0];
            int col=j+dir[k][1];
            ans=ans & dfs(grid1,grid2,row,col);
        }
        return ans;
            
        
    }
}