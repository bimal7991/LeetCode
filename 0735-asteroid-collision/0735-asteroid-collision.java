class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i:asteroids){
            if(st.isEmpty()){
                st.push(i);
            }else{
                if(i>0)
                st.push(i);
                else{
                    if(st.peek()<0)
                    {
                        st.push(i);
                        continue;
                    }
                    while(!st.isEmpty() && st.peek()>0 && st.peek()+i<0){
                        st.pop();
                    }
                    if(st.isEmpty() || st.peek()<0){
                        st.push(i);
                    }
                    else if(!st.isEmpty() && st.peek()==-i){
                        st.pop();
                    }
                         
                }
            }
        }
        System.out.println(st);
        Object[] arr = st.toArray();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=(int)arr[i];
        }
        return ans;
    }
}