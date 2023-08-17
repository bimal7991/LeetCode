class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dis[][]=new int[n][m];
        int vis[][]=new int[n][m];
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    dis[i][j]=0;
                }
            }
        }
        
        while(!q.isEmpty()){
            int arr[]=q.poll();
            dis[arr[0]][arr[1]]=arr[2];
           
            for(int d[]:dir){
                int r=d[0]+arr[0];
                int c=d[1]+arr[1];
                if(r>=0 && r<n && c>=0 && c<m  && mat[r][c]==1 && vis[r][c]==0){
                    vis[r][c]=1;
                    q.add(new int[]{r,c,arr[2]+1});
                }
            }
        }
        return dis;
        
        
        
    }
}