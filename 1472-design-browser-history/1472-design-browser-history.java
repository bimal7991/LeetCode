class BrowserHistory {
     Stack<String> st=new Stack<>();
    Stack<String> fo=new Stack<>();
    public BrowserHistory(String homepage) {
        st.push(homepage);
    }
    
    public void visit(String url) {
        st.push(url);
        fo.clear();
    }
    
    public String back(int steps) {
        String ans="";
        while(st.size()!=1 && steps>0){
            ans=st.pop();
            fo.add(ans);
            steps--;
        }
        return st.peek();
    }
    
    public String forward(int steps) {
       
        String ans="";
        while(!fo.isEmpty() && steps>0){
            ans=fo.pop();
            st.add(ans);
            steps--;
        }
        return st.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */