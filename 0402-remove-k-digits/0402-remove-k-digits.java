class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(char c:num.toCharArray()){
            if(st.isEmpty())
                st.push(c);
            else if(st.peek()-'0'>c-'0'){
                while(!st.isEmpty() && k>0 && st.peek()-'0'>c-'0'){
                    st.pop();
                    k--;
                }
                st.push(c);
            }
            else
                st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder s=new StringBuilder();
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        String reverse=s.reverse().toString();
        // System.out.println(reverse);
        int i=0;
        for( i=0;i<reverse.length();i++){
            if(reverse.charAt(i)!='0')
                break;
        }
        return reverse.substring(i).length()==0?"0":reverse.substring(i);
    }
}