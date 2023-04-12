class Solution {
    public String simplifyPath(String path) {
        String sp[]=path.split("/");
        Stack<String> st=new Stack<>();
        for(int i=0;i<sp.length;i++){
            if(sp[i].equals("..")){
                if(!st.isEmpty())
                    st.pop();
                continue;
            }
            else if(sp[i].equals(".") || sp[i].equals(""))
                continue;
            st.push(sp[i]);
            
        }
        String ans="";
        while(!st.isEmpty()){
            if(ans.equals(""))
                ans=st.pop()+ans;
            else
            ans=st.pop()+"/"+ans;
        }
        ans="/"+ans;
        
        return ans;
    }
}