class Solution {
    public int countStudents(int[] stud, int[] san) {
        Queue<Integer> st=new LinkedList<Integer>();
        for(int i=0;i<stud.length;i++)
        {
            st.add(i);
        }
        int i=0;
        int vis[]=new int[stud.length];
        Arrays.fill(vis,-1);
        while(!st.isEmpty() && vis[st.peek()]==-1){
            vis[st.peek()]=1;
            if(stud[st.peek()]==san[i]){
                st.poll();
                i++;
                Arrays.fill(vis,-1);
            }
            else{
                st.add(st.poll());
            }
        }
        return st.size();
    }
}