//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] obstacleGrid) {
        // code here
        
        
        long dp[][]=new long[n][m];
        if(n>=1 && m>=1){
            if(obstacleGrid[0][0]==0)
                return 0;
        }
        
        for(int i=0;i<m;i++){
            if(obstacleGrid[0][i]==1)
            dp[0][i]=1;
            else
                break;
            
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[i][0]==1)
            dp[i][0]=1;
            else
                break;
            
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==1)
                dp[i][j]=(dp[i][j-1]+dp[i-1][j])%1000000007;
                else
                    dp[i][j]=0;
            }
        }
                
   return (int)dp[n-1][m-1];
    }
};