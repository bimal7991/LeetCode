class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0')
                    dp[i][j]=0;
                else
                    dp[i][j]= i==0?1: 1+dp[i-1][j];
            }
        }
        int max=0;
        for(int d[]:dp){
            System.out.println(Arrays.toString(d));
            int next[]=nextSmaller(d);
            int prev[]=prevSmaller(d);
            for(int i=0;i<d.length;i++){
                max=Math.max((next[i]-prev[i]-1)*d[i],max);
            }
        }
        return max;
        
    }
    public int[] nextSmaller(int arr[]){       // 3 4 5 2 2 1 5 6 
                                                                
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] prevSmaller(int arr[]){       // 3 4 5 2 1 5 6 
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
}