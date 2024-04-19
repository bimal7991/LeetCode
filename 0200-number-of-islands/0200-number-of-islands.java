class Solution {
    int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
         int n=grid.length;
         int m=grid[0].length;
         int vis[][]=new int[n][m];
         int arr[]=new int[1];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(vis[i][j]==0 && grid[i][j]=='1'){
                   dfs(grid,i,j,arr,vis);
                   count++;
               } 
            }
        }     
         return count;
    }
    
  void dfs(char[][] grid ,int i,int j,int arr[],int vis[][]) {
	if( i<0 || j<0 || (i==grid.length || j==grid[0].length) || grid[i][j]=='0' || vis[i][j]==1) {
		return;
	}  
	vis[i][j]=1;
	//System.out.println(node);
      for(int k=0;k<dir.length;k++){
           int row=i+dir[k][0];
            int col=j+dir[k][1];
             dfs(grid,row,col,arr,vis);
        }   
	}
    
}