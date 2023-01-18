//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int a, int b, int c, int d) { 
        //code here
        int count1=0;
        int n=a;
        while(n>c){
            n=n/2;
            count1++;
        }
        
        int m=b;
        while(m>d){
            m=m/2;
            count1++;
        }
        int count2=0;
        while(a>d){
            a=a/2;
            count2++;
        }
        while(b>c){
            b=b/2;
            count2++;
        }
        return Math.min(count1,count2);
        
        
    }
   
}
