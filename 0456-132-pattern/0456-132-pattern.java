class Solution {
    public boolean find132pattern(int[] nums) {
        // Stack<Integer> st=new Stack<Integer>();
       
        Stack<Integer> st=new Stack<>();
         int last=Integer.MIN_VALUE;
         for(int i=nums.length-1;i>=0;i--){
                if(last>nums[i])
                    return true;

                while(!st.isEmpty() && nums[i]>st.peek()){
                    last=Math.max(last,st.pop());
                }
                st.push(nums[i]);

         }   
         return false;
        
        // return false;
        
    }
}