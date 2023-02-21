//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int count=0;
		int dir[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
		Queue<int[]> q=new LinkedList<>();
		x--;
		y--;
		int vis[][]=new int[N][M];
		vis[x][y]=1;
		q.add(new int[]{x,y});
		while(!q.isEmpty()){
		    int s=q.size();
		    for(int i=0;i<s;i++){
		        int arr[]=q.poll();
		        for(int j=0;j<4;j++){
		            int r=arr[0]+dir[j][0];
		            int c=arr[1]+dir[j][1];
		            if(r<N && r>=0 && c>=0 && c<M && vis[r][c]==0){
		                vis[r][c]=1;
		                 q.add(new int[]{r,c});
		            }
		              
		        }
		    }
		    count++;
		}
		return count-1;
		
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends