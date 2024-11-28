class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n=grid.length;
        int m=grid[0].length;
        int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        q.add(new int[]{0,0,grid[0][0]==1?1:0});
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int []temp=q.poll();
                for(int d[]:dir){
                    int r=d[0]+temp[0];
                    int c=d[1]+temp[1];
                    if(r<0 || r>=n || c<0 || c>=m || grid[r][c]==2)
                        continue;
                    int count=grid[r][c]==1?1:0;
                    if(r==n-1 && c==m-1)
                        return temp[2]+count;
                    
                    if(grid[r][c]==1){
                        q.add(new int[]{r,c,temp[2]+1});
                        grid[r][c]=2;
                    }
                    else{
                       q.add(new int[]{r,c,temp[2]});
                        grid[r][c]=2; 
                    }
                        
                }
            }
        }
        return -1;
    }
}