class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
       
        int n=nums.length;
         int ans[]=new int[n];
        Arrays.fill(ans,-1);
        for(int i=n-1;i>=0;i--) 
                st.push(nums[i]);
            
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(nums[i]);
        }
        
        return ans;
    }
}