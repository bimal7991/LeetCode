class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> st=new Stack<>();
        st.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(i);
            else{
                boolean flag=true;
                if(st.size()!=1 && s.charAt(st.peek())=='(')
                {
                    flag=false;
                    st.pop();
                    max=Math.max(max,i-st.peek()); 
                }
                 
                  if(flag)
                      st.push(i);
            }
        }
        return max;
    }
}