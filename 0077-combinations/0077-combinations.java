class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        helper(list,n,k,new ArrayList<Integer>(),1);
        return list;
    }
    void helper(List<List<Integer>> list,int n,int k,List<Integer> sub,int j){
        if(sub.size()==k){
            list.add(new ArrayList<>(sub));
            
            return;
        }
        for(int i=j;i<=n;i++){
            sub.add(i);
            helper(list,n,k,sub,i+1);
            sub.remove(sub.size()-1);
        }
    }
}