class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> lis =new ArrayList<>();
        solve(nums,nums.length,lis,ans,0);
        return ans;
    }
    void solve(int arr[], int N,List<Integer> lis, List<List<Integer>> ans,int id){
        if(id>=N){
            ans.add(lis);
            return;
        }
        
        ArrayList<Integer> pre=new ArrayList<Integer>(lis);
        lis.add(arr[id]);
         
         solve(arr,N,lis,ans,id+1);
         solve(arr,N,pre,ans,id+1);
        
    }
}