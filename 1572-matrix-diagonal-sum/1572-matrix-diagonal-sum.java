class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int sum=0;
        for(int i=0;i<n;i++){
            int col1=i;
            int col2=m-1-i;
            sum=sum+mat[i][col2];
            if(col1==col2)
                continue;
             sum=sum+mat[i][col1];
        }
        return sum;
    }
}