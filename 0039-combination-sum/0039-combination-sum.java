class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,target,candidates,0,new ArrayList<>(),ans);
        return ans;
    }
    void helper(int sum,int target,int candidates[],int i,List<Integer> sub,List<List<Integer>> ans){
        if(sum>target || i==candidates.length)
            return;
        if(sum==target)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int j=i;j<candidates.length;j++){
            sum=sum+candidates[j];
            sub.add(candidates[j]);
            helper(sum,target,candidates,j,sub,ans);
            sum=sum-candidates[j];
            sub.remove(sub.size()-1);                   
        }
    }
}