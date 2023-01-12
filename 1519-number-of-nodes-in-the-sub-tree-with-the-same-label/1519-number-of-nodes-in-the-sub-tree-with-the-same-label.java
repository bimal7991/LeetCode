class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer> list[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            list[i]=new ArrayList<Integer>();
        for(int arr[]:edges){
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }
        int  res[]=new int[n];
        dfs(0,-1,list,labels,res);
        return res;
        
        
    }
    public int[] dfs( int node,int parent,ArrayList<Integer> []list,String labels,int res[]){
        int arr[]=new int[26];    
        for(int child:list[node]){
            if(child==parent)
                continue;
            int temp[]=dfs(child,node,list,labels,res);
            for(int i=0;i<26;i++){
                arr[i]=arr[i]+temp[i];
            }
            
        }
        res[node]=++arr[labels.charAt(node)-'a'];
        return arr;
    }
}