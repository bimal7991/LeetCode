class Solution {
    public int matrixScore(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                for(int j=0;j<m;j++){
                    grid[i][j]= (grid[i][j]==0?1:0);
                }
            }
        }
        int dp[]=new int[m];
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]==1)
                    count++;
            }
            dp[i]=count;
        }
        // System.out.println(Arrays.toString(dp));
        for(int i=0;i<m;i++){
            if(dp[i]<n-dp[i]){
            for(int j=0;j<n;j++){
                grid[j][i]= (grid[j][i]==0?1:0);
            }
          } 
        }
        int sum=0;
        for(int a[]:grid){
          sum=sum+binaryArrayToDecimal(a);
            
        }
        return sum;
        
        
    }
    public int binaryArrayToDecimal(int[] arr) {
        int decimal = 0;
        for (int i = 0; i < arr.length; i++) {
            decimal += arr[i] * Math.pow(2, arr.length - i - 1);
        }
        return decimal;
    }
}