class Solution {
    public int maxDistance(int[][] mat) {
        int dir[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
         int n=mat.length;
         int m=mat[0].length;
         int vis[][]=new int[n][m];
         int dis[][]=new int[n][m];
        for(int d[]:dis)
        Arrays.fill(d,-1);
         Queue<int[]> q=new LinkedList<>();
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 if(mat[i][j]==1){
                     q.add(new int[]{i,j,0});
                     vis[i][j]=1;
                 }
             }
         }

         while(!q.isEmpty()){
             int arr[]=q.poll();
             dis[arr[0]][arr[1]]=arr[2];
             for(int d[]:dir){
                 int r=arr[0]+d[0];
                 int c=arr[1]+d[1];
                 if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==0){
                     vis[r][c]=1;
                     q.add( new int[]{r,c,arr[2]+1});
                     
                 }
             }

         }
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    max=Math.max(max,dis[i][j]);
                }
            }
        }
        return max;
    }
}