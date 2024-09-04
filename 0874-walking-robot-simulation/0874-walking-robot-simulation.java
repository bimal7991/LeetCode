class Solution {
     public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, j = 0, result = 0;
		int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};//Directions for robot to move in
        
        Set<String> ops = new HashSet<>();
        
        for(int[] op : obstacles) {//Stores the position of the obstacles
            ops.add(op[0] + " " + op[1]);
        }
        
        for(int i=0; i<commands.length; i++) {
            if(commands[i]==-1) {//If right
               j = (j+1)%4;
            }else if(commands[i]==-2) {//If left
                j = (j+3)%4;
            }else {
                while(commands[i]-- >0 && !ops.contains((x+d[j][0])+ " " +(y+d[j][1]))) {//Travel how ever many units or until the next position is an obstacle
                    x += d[j][0];
                    y += d[j][1];
                }
            }
            result = Math.max(result, x*x + y*y);//Calculate the maximum distance
        }
        return result;
    }
}