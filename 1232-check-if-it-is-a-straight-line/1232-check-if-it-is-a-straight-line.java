class Solution {
    public boolean checkStraightLine(int[][] c) {
        if(c.length==2)
            return true;
        
        int y=c[1][1]-c[0][1];
        int x=c[1][0]-c[0][0];
        
        
        for(int i=2;i<c.length;i++){
            int y1=c[i][1]-c[0][1];
             int x1=c[i][0]-c[0][0];
            if(y*x1!=x*y1)
                return false;
        }
        return true;
    }
}