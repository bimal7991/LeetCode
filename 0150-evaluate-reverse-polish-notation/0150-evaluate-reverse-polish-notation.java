class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<Integer>();
        int ans=0;
        for(String s:tokens){
            if(s.equals("+"))
            {
                int first=st.pop();
                int second=st.pop();
                int val=second+first;
                st.push(val);
                ans=val;
            }
            else if(s.equals("-"))
            {
                int first=st.pop();
                int second=st.pop();
                int val=second-first;
                st.push(val);
                ans=val;
            } 
            else if(s.equals("*"))
            {
                int first=st.pop();
                int second=st.pop();
                int val=second*first;
                st.push(val);
                ans=val;
            } 
            else if(s.equals("/"))
            {
                int first=st.pop();
                int second=st.pop();
                int val=second/first;
                st.push(val);
                ans=val;
            }
            else{
            int n=Integer.valueOf(s);
                st.push(n);
                ans=n;
               // System.out.println(st);
            }    
            
        }
        return ans;
    }
}