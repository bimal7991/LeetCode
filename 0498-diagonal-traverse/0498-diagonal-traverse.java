class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int ans[]=new int[n*m];
        int i=0,j=0;
        int k=0;
        for(k=0;k<ans.length;k++){
            ans[k]=mat[i][j];
            if((i+j)%2==0){
                if(j==m-1)
                    i++;
                else if(i==0)
                    j++;
                else{
                    i--;
                    j++;
                }    
            }
            else{
                if(i==n-1)
                    j++;
                else if(j==0)
                    i++;
                else{
                    i++;
                    j--;
                }    
            }
        }
        return ans;
        
    }
}