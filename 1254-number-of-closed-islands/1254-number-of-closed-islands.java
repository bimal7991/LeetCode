class Solution {
    int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int closedIsland(int[][] grid) {
       int n=grid.length;
         int m=grid[0].length;
         int vis[][]=new int[n][m];
         int arr[]=new int[1];
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(vis[i][j]==0 && grid[i][j]==0){
                   if(dfs(grid,i,j,arr,vis))
                   count++;
               } 
            }
        } 
        return count;
          
    }
    boolean dfs(int[][] grid ,int i,int j,int arr[],int vis[][]) {
    
	if( i<0 || j<0 || (i>=grid.length || j>=grid[0].length)) {
		return false;
	} 
    if(grid[i][j]==1 || vis[i][j]==1)
            return true;
   
	vis[i][j]=1;
	//System.out.println(node);
     boolean ans=true;
      for(int k=0;k<dir.length;k++){
           int row=i+dir[k][0];
            int col=j+dir[k][1];
             ans =ans & dfs(grid,row,col,arr,vis);
        }
        return ans;
        
	}
}