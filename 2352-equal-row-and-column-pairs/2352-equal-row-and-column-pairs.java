class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        for(int g[]:grid){
            boolean flag=true;
            for(int i=0;i<grid.length;i++){
                 flag=true;
                for(int j=0;j<grid.length;j++){
                    if(g[j]!=grid[j][i]){
                        flag=false;
                        break;
                    }
                }
                  if(flag){
                        count++;
                  }
              
                   
            }
        }
        return count;
        
    }
}