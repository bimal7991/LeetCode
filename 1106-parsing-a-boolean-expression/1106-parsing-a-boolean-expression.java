class Solution {
    public boolean parseBoolExpr(String s) {
       Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' ||  c==',')
                continue;
            if(c=='&' || c=='!' || c=='|' || c=='f' || c=='t')
                st.push(c);
            else{
                int countT=0;
                int count=0;
                while(st.peek()!='|' && st.peek()!='&' && st.peek()!='!')
                {
                    char t=st.pop();
                    if(t=='t')
                        countT++;
                    count++;
                }
                char op=st.pop();
                boolean v=false;
                if(op=='|')
                    v= countT>0?true:false;
                else if(op=='&')
                    v= (countT==count)?true:false;
                else 
                    v=countT>0?false:true;
                if(v)
                    st.push('t');
                else
                    st.push('f');
                    
            }
        }
        return st.peek()=='t';
    }
}