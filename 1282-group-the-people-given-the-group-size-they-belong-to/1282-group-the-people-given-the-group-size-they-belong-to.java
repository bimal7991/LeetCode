class Solution {
    public List<List<Integer>> groupThePeople(int[] g) {
        int n=g.length;
        ArrayList<Integer> arr[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            arr[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[g[i]].add(i);
        }
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            if(arr[i].size()>0){
              List<Integer> list=arr[i];
                int j=0;
              while(j<=list.size()-i){
                  ans.add(list.subList(j,j+i));
                  j=j+i;
              }
            }
            
        }
        return ans;
        
        
    }
}