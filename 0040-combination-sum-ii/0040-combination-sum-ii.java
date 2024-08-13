class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> list=new ArrayList<>();
            helper(list,candidates,target,0,new ArrayList<>(),0);
        return list;
    }
    public void helper(List<List<Integer>> list,int nums[],int target,int i,List<Integer> sub,int sum){
        
        if(target==sum){
            list.add(new ArrayList<>(sub));
            return;
        }
        if(i==nums.length || sum>target)
            return;
        
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1])
                continue;
            sub.add(nums[j]);
            helper(list,nums,target,j+1,sub,sum+nums[j]);
            sub.remove(sub.size()-1);
        }
        
    }
}