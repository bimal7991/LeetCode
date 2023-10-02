class Solution {
    public int largestRectangleArea(int[] heights) {
        int next[]=nextSmaller(heights);
        int prev[]=prevSmaller(heights);
          //System.out.println(Arrays.toString(next));
        int max=0;
        for(int i=0;i<heights.length;i++){
            int h=heights[i];
             if(next[i]==-1)
                next[i]=heights.length;
            int b=next[i]-prev[i]-1;
            max=Math.max(max,b*h);
            
        }
        return max;
        
    }
    public int[] nextSmaller(int arr[]){
        int ans[]=new int[arr.length];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
       public int[] prevSmaller(int arr[]){
        int ans[]=new int[arr.length];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
}