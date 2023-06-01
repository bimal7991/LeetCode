class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int n=grid.length;
        Queue<int[]> q=new LinkedList<>();
        if(grid[0][0]==1)
            return -1;
        q.add(new int[]{0,0,1});
        grid[0][0]=1;
        while(!q.isEmpty()){
            int temp[]=q.poll();
            if(temp[0]==n-1 && temp[1]==n-1)
                return temp[2];
            for(int d[]:dir){
                int r=d[0]+temp[0];
                int c=d[1]+temp[1];
                if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==0){
                    q.add(new int[]{r,c,temp[2]+1});
                    grid[r][c]=1;
                }
            }
        }
        return -1;
    }
}