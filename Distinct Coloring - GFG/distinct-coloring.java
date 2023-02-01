//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        
        int prevc=0;
        int sum=0;
        long dp[][]=new long[N+1][4];
        dp[0][1]=r[0];
        dp[0][2]=g[0];
        dp[0][3]=b[0];
        for(int i=1;i<N;i++){
           
             dp[i][1]=r[i]+Math.min(dp[i-1][2],dp[i-1][3]);
            dp[i][2]=g[i]+Math.min(dp[i-1][1],dp[i-1][3]);
            dp[i][3]=b[i]+Math.min(dp[i-1][1],dp[i-1][2]);
             
        }
        return Math.min(dp[N-1][1],Math.min(dp[N-1][2],dp[N-1][3]));
        
       // return helper(N,r,g,b,0,0,dp);
        
        
        
    }
   static long helper(int N,int[]r, int[]g, int[]b,int i,int c,long dp[][]){
        if(i==N)
        return 0;
        if( dp[i][c]!=0)
          return dp[i][c];
        
        
        if(c==0){
            long red=r[i]+helper(N,r,g,b,i+1,1,dp);
            long green=g[i]+helper(N,r,g,b,i+1,2,dp);
            long blue=b[i]+helper(N,r,g,b,i+1,3,dp);
            return dp[i][c]=Math.min(red,Math.min(green,blue));
            
        }
        else if(c==1){
            long green=g[i]+helper(N,r,g,b,i+1,2,dp);
            long blue=b[i]+helper(N,r,g,b,i+1,3,dp);
            return dp[i][c]=Math.min(green,blue);
        }
        else if(c==2){
            long red=r[i]+helper(N,r,g,b,i+1,1,dp);
            long blue=b[i]+helper(N,r,g,b,i+1,3,dp);
          return  dp[i][c]=Math.min(red,blue);
        }
        else{
            long red=r[i]+helper(N,r,g,b,i+1,1,dp);
             long green=g[i]+helper(N,r,g,b,i+1,2,dp);
            return dp[i][c]=Math.min(red,green);
        }
        
        
    }
    
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends