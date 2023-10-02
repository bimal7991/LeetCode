class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
             int min=Integer.MAX_VALUE;
             while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                 int h=heights[st.pop()];
                 int w=st.isEmpty()? i :i-st.peek()-1;
                  max=Math.max(max,w*h);
                
             }
             st.push(i);
             
        }
        int min=Integer.MAX_VALUE;
        
        System.out.println(st);
        while(!st.isEmpty()){
            int h=st.pop();
            int w=st.isEmpty()? heights.length :heights.length-st.peek()-1;
            max=Math.max(max,w*heights[h]);
           
        }
        return max;
        
    }
}