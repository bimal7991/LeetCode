//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int n=arr.length;
		int ans[]=new int[n];
		Stack<Integer> st=new Stack<>();
	
		for(int i=0;i<n;i++){
		    while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
		        st.pop();
		    }
		    
		    
		    if(st.isEmpty()){
		        ans[i]=-1;
		    }
		    else{
		        ans[i]=st.peek();
		    }
		    st.add(i);
		}
		st=new Stack<>();
	//System.out.println(Arrays.toString(ans));
		for(int i=n-1;i>=0;i--){
		    while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
		        st.pop();
		    }
		    
		    
		    if(st.isEmpty()){
		        ans[i]= (ans[i]==-1)?-1:ans[i];
		        
		    }
		    else{
		        if(ans[i]==-1)
		          ans[i]=st.peek();
		        
		        if(arr[ans[i]]==arr[st.peek()])
		          ans[i]= Math.min(ans[i],st.peek());
		          
		        int d1=Math.abs(ans[i]-i);
		        int d2=Math.abs(st.peek()-i);
		        if(d1==d2){
		            ans[i]=(arr[ans[i]]>arr[st.peek()])?st.peek():ans[i];
		        }
		        else if(d2<d1){
		            ans[i]=st.peek();
		        }
		        
		        
		            
		    }
		    st.add(i);
		}
		
		
		
		return ans;
		
		
	}
}