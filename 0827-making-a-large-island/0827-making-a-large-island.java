class Solution {
    int dir[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] mat) {
        
     int n=mat.length;
    int m=mat[0].length;
    int dp[][]=new int[n][m];
    int index[]=new int[n*m+2];
     int k=2;
    int max=0;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
         HashSet<int[]> set=new HashSet<>();
        if(mat[i][j]==1){
          set.add(new int[]{i,j});
          int count=dfs(mat,i,j,dp,set);
          max=Math.max(max,count);
          index[k]=count;
          for(int arr[]:set){
            dp[arr[0]][arr[1]]=k;
          }
          k++;
        }
        
      }
    }
    // System.out.println(Arrays.toString(index));
    // for(int i=0;i<n;i++){
    //   for(int j=0;j<m;j++){
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
   
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(dp[i][j]==0){
          int sum=0;
          HashSet<Integer> hs=new HashSet<>();
          int r1= (j-1>=0 ?dp[i][j-1]:0);
          int r2=(j+1<m?dp[i][j+1]:0);
          int r3= (i-1>=0 ?dp[i-1][j]:0);
          int r4=(i+1<n?dp[i+1 ][j]:0);
          hs.add(r1);
          hs.add(r2);
          hs.add(r3);
          hs.add(r4);
          for(int p:hs)
            sum=sum+index[p];
          
          max=Math.max(sum+1,max);
        }
      }
    }
    
    return max;
  }
  int dfs(int mat[][],int r,int c,int dp[][],HashSet<int[]> set){
       if (r < 0 || r == mat.length || c < 0 || c == mat[0].length || mat[r][c] != 1) return 0;
        int size = 1;
        mat[r][c] = 0;
        set.add(new int[]{r,c});
        for (int i = 0; i < 4; i++)
            size += dfs(mat, r + dir[i][0], c + dir[i][1],dp,set);
        return size;
  }
}