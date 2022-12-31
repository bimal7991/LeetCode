class Solution {
    
    public int uniquePathsIII(int[][] grid) {
        int ans[]=new int[1];
         int count=1;
        int n=grid.length;
        int m=grid[0].length;
        int s=-1,e=-1;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)
                    count++;
                if(grid[i][j]==1)
                {
                    s=i;
                    e=j;
                 }
                
            }
        }
        helper(grid,0,count,s,e,vis,ans);
        return ans[0];
        
    }
    void helper(int grid[][],int ob,int count,int i,int j,int vis[][],int ans[]){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]==1 || grid[i][j]==-1)
            return;
        
       
        if(grid[i][j]==2 ){
            if(count==0){
            ans[0]++;
            }
            return;
           
        }
        vis[i][j]=1;
        count--;
        helper(grid,ob,count,i+1,j,vis,ans);
        helper(grid,ob,count,i,j+1,vis,ans);
        helper(grid,ob,count,i-1,j,vis,ans);
        helper(grid,ob,count,i,j-1,vis,ans);
        count++;
        vis[i][j]=0;
    }
}