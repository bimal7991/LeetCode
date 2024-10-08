class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')
                st.push(c);
            else{
                if( !st.isEmpty() && st.peek()=='(')
                    st.pop();
                else
                    st.add(c);
            }
            
        }
        return st.size();
    }
}