class Solution {
    int dir[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] mat) {
        
    int n=mat.length;
    int m=mat[0].length;
    HashMap<Integer,Integer> hm=new HashMap<>();
    hm.put(0,0);
    int k=2;
    int max=0;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(mat[i][j]==1){
          int count=dfs(mat,i,j,k);
          hm.put(k,count);
          max=Math.max(max,count);
          k++;
        }
        
      }
    }
    // System.out.println(hm);
    // for(int i=0;i<n;i++){
    //   for(int j=0;j<m;j++){
    //     System.out.print(mat[i][j]+" ");
    //   }
    //   System.out.println();
    // }
   
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(mat[i][j]==0){
          int sum=0;
          HashSet<Integer> hs=new HashSet<>();
          int r1= (j-1>=0 ?mat[i][j-1]:0);
          int r2=(j+1<m?mat[i][j+1]:0);
          int r3= (i-1>=0 ?mat[i-1][j]:0);
          int r4=(i+1<n?mat[i+1 ][j]:0);
          hs.add(r1);
          hs.add(r2);
          hs.add(r3);
          hs.add(r4);
          for(int p:hs)
            sum=sum+hm.get(p);
          
          max=Math.max(sum+1,max);
        }
      }
    }
    
    return max;
  }
  int dfs(int mat[][],int r,int c,int k){
       if (r < 0 || r == mat.length || c < 0 || c == mat[0].length || mat[r][c] != 1)         return 0;
        int size = 1;
        mat[r][c] = k;
        for (int i = 0; i < 4; i++)
            size += dfs(mat, r + dir[i][0], c + dir[i][1],k);
        return size;
  }
}