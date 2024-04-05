class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }
            else{
                char d=st.peek();
                if(d==c)
                    st.push(c);
                else if(Character.toUpperCase(d)==Character.toUpperCase(c))
                    st.pop();
                else
                    st.push(c);
                
            }
            
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
           ans.append(st.pop());   
        }
        return ans.reverse().toString();
    }
}