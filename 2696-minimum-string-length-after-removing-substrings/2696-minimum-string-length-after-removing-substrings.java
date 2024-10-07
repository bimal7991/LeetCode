class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='B' && !st.isEmpty() && st.peek()=='A'){
                st.pop();
            }
            else if(c=='D' && !st.isEmpty() && st.peek()=='C')
                st.pop();
            else
                st.add(c);
        }
        return st.size();
    }
}