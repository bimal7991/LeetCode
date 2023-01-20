//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int num1, int num2) {
        // code here
        if(num1 == num2) return num1;
		
        int bit = Integer.bitCount(num2);
		
      char ans[]=new char[32];
      Arrays.fill(ans,'0');
        for(int i=31;i>=0;i--) {
			int currBit = (num1 >> i) & 1;
            if(currBit == 1 && bit > 0) {
				ans[i]='1';
                bit--;
            }
        }
        
        for(int i=0;i<32;i++) {
            if(bit == 0) break;
			
            if(ans[i]=='0') {
                ans[i]='1';
                bit--;
            }
        }
       int flag = 1, binary=0;
        
        for(int i=0;i<32;i++){
            if(ans[i] == '1'){
                binary+=flag;
            }
            flag*=2;
        }
        return binary;
      
        
    }
}