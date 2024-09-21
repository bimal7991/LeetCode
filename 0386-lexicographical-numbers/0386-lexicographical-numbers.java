class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<>();
       for(int i=1;i<=9;i++)     
        dfs(n,i,list);
        return list;
    }
    public void dfs(int n,int i,List<Integer> list){
        if(i>n)
            return;
        list.add(i);
        for(int j=0;j<=9;j++){
            dfs(n,i*10+j,list);
        }
    }
}