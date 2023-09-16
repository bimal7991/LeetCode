class Solution {
    
    public int minimumEffortPath(int[][] h) {
        int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        int efforts[][]=new int[h.length][h[0].length];
        for(int ef[]:efforts){
            Arrays.fill(ef,Integer.MAX_VALUE);
        }
        q.add(new int[]{0,0,0});
        efforts[0][0]=0;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            for(int d[]:dir){
                int r=curr[0]+d[0];
                int c=curr[1]+d[1];
                if(r<0 || r>=h.length || c<0 || c>=h[0].length)
                    continue;
                int diff=Math.max(curr[2],Math.abs(h[r][c]-h[curr[0]][curr[1]]));
                if(diff<efforts[r][c]){
                    efforts[r][c]=diff;
                    q.add(new int[]{r,c,diff});
                }
            }
        }
        return efforts[h.length-1][h[0].length-1];
        
        
    }
   
}