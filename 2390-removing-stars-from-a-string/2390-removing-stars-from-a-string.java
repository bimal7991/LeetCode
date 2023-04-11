class Solution {
    public String removeStars(String s) {
        Stack<Character>  st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c!='*'){
                st.push(c);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        StringBuilder sub=new StringBuilder();
        while(!st.isEmpty()){
            sub.append(st.pop());
        }
        return sub.reverse().toString();
        
        
    }
}