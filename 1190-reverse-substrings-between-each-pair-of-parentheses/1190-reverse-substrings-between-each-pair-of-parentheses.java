class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c==')'){
                String ans="";
                while(st.peek()!='('){
                    ans=ans+st.pop();
                }
                st.pop();
                for(char t:ans.toCharArray())
                    st.push(t);
            }
            else
                st.add(c);
        }
        // System.out.println(st);
        String result = st.stream()
                                 .map(String::valueOf)
                                 .collect(Collectors.joining());
        return result;
    }
}