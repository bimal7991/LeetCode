//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] a) {
        // code here
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<N;i++){
 
            int flag=0;
            while(!st.isEmpty() && st.peek()>0 && a[i]<0){
                int cur=a[i];
                int p=st.peek();
                if(Math.abs(cur)==Math.abs(p)){
                   st.pop();
                   flag=1;
                   break;
                }
                else{
                    if(Math.abs(cur)>Math.abs(p)){
                        st.pop();
                        
                    }else{
                        flag=1;
                        break;
                    }
                }   
            }
            if(flag==0)
            st.add(a[i]);
        }
        //System.out.println(st);
        int ans[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}
