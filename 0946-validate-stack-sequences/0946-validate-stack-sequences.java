class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n=pushed.length;
        Stack<Integer> st=new Stack<>();
        int i=0;
        int j=0;
        while(i<n){
            int p=popped[i];
            if(st.isEmpty() || st.peek()!=p){
                if(j==n)
                    return false;
                else{
                    while(j<n && pushed[j]!=p){
                        st.push(pushed[j]);
                        j++;
                    }
                    if(j==n)
                        return false;
                    j++;
                    
                }
            
                   
            }
            else if(st.peek()==p){
                st.pop();
            }
            i++;
        }
        return true;
    }
}