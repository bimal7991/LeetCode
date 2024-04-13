class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    dp[i][j]=matrix[i][j]=='1'?1:0;
                }
                else if(matrix[i][j]=='1'){
                    dp[i][j]=dp[i-1][j]+1;
                }
            }
        }
        int max=0;
        for(int arr[]:dp){
            int[] prevSmaller=findPrevSmaller(arr);
            int[] nextSmaller=findNextSmaller(arr);
            for(int i=0;i<arr.length;i++){
                int prev=prevSmaller[i];
                int next=nextSmaller[i];
                max=Math.max(max,(next-prev-1)*arr[i]);
            }
        }
        return max;
    }
    public int[] findPrevSmaller(int arr[]){
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
                while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                ans[i]= st.isEmpty()?-1:st.peek();
                st.push(i);
        }
        // System.out.println("Prev Smaller -> "+Arrays.toString(ans));
       return ans; 
    }
    public int[] findNextSmaller(int arr[]){
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
                while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                ans[i]= st.isEmpty()?arr.length:st.peek();
                st.push(i);
        }
        // System.out.println("Next Smaller -> "+Arrays.toString(ans));
       return ans; 
    }
}