//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			String S[] = read.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(S[i]);
			int k = Integer.parseInt(read.readLine());

			Solution ob = new Solution();
			System.out.println(ob.countPairs(n, arr, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static long countPairs(int n, int[] arr, int k) {
		// code here
		
		int rem[]=new int[k];
		for(int i=0;i<n;i++){
		    int r=arr[i]%k;
		    rem[r]++;
		}
	   long sum=0;
	   for(int i=0;i<k;i++){
	        if(rem[i]>1){
	            sum=sum+nCr(rem[i],2);
	        }   
	   }
		return sum;
	}
	static long nCr(int n, int r)
{
    if(n==2)
    return 1;
    return  (n*(n-1))/2;
}
 
// Returns factorial of n
static long fact(int n)
{
      if(n==0)
      return 1;
    long res = 1;
    for (int i = 2; i <= n; i++)
        res = res * i;
    return res;
}
}