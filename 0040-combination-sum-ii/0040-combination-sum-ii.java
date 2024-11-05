class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,target,candidates,0,new ArrayList<>(),ans);
        return ans;
    }
    void helper(int sum,int target,int candidates[],int i,List<Integer> sub,List<List<Integer>> ans){
        
        if(sum==target)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(sum>target || i==candidates.length)
            return;
        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1])
                continue;
            sum=sum+candidates[j];
            sub.add(candidates[j]);
            helper(sum,target,candidates,j+1,sub,ans);
            sum=sum-candidates[j];
            sub.remove(sub.size()-1);                   
        }
    }
}