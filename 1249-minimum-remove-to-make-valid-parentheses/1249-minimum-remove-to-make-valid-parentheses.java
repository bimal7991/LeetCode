class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='(')
               st.push(i);
            else if(s.charAt(i)==')' && !st.isEmpty() && s.charAt(st.peek())=='(')
                st.pop();
            else if(s.charAt(i)==')')
                st.push(i);
                    
        }
       while(!st.isEmpty()){
           hs.add(st.pop());
       }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!hs.contains(i))
                ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}