class Solution {
    public boolean checkValidString(String s) {
         int count=0;
        List<Integer> list=new ArrayList<>();
         Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*')
                list.add(i);
           else if(s.charAt(i)=='(')
               st.push(i);
            else if(s.charAt(i)==')' && !st.isEmpty() && s.charAt(st.peek())=='(')
                st.pop();
            else if(s.charAt(i)==')')
                st.push(i);       
        }
        int i=list.size()-1;
        // System.out.println(st);
        // System.out.println(list);
        while(!st.isEmpty() && i>=0){
            int a=st.peek();
            if(s.charAt(a)=='('){
                if(list.get(i)>a)
                {
                    st.pop();
                    i--;
                }
                else
                    return false;
            }
            else{
                while(i>=0 && list.get(i)>a){
                    i--;
                }
                if(i>=0)
                {
                    st.pop();
                    i--;
                }
                else
                    return false;
            }
            
        }
        if(st.isEmpty())
            return true;
        
        return false;
    }
}