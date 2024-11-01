class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
         Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && heights[st.peek()]<heights[i]){
                st.pop();
                count++;
            }
            if(!st.isEmpty() && heights[i]<heights[st.peek()])
               ans[i]=count+1;
            else
                ans[i]=count;
            st.push(i);
            
        }
        return ans;
    }
}