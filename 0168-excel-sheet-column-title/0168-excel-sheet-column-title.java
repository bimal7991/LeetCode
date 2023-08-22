class Solution {
    public String convertToTitle(int n) {
        StringBuilder st=new StringBuilder();
        while(n>26){
            int mod=n%26;
            char c= (char)('A'+mod-1);
            if(mod==0)
                st.append('Z');
            else
            st.append(c);
            if(mod==0){
                n=n-26;
            }
            n=n/26;
        }
         char c= (char)('A'+n-1);
         st.append(c);                        
        return st.reverse().toString();
    }
}