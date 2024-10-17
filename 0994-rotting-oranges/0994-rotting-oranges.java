class Solution {
    public int orangesRotting(int[][] grid) {
        int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        int sp=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    sp++;
                }
            }
        }
        if(q.isEmpty() && sp==0)
            return 0;
        int count=0;
        while(!q.isEmpty()){
            int s=q.size();
            count++;
            for(int j=0;j<s;j++){
            int d[]=q.poll();
           
            for(int i=0;i<4;i++){
                int r=d[0]+dir[i][0];
                int c=d[1]+dir[i][1];
                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                    grid[r][c]=2;
                    q.add(new int[]{r,c});
                    sp--;
                }
            }
            }
        }
        
        return sp!=0?-1: count-1;
        
    }
}