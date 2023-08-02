class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        
        helper(nums,list,0);
        return list;
    }
    void helper(int nums[],List<List<Integer>> list,int k){
        if(k==nums.length){
            List<Integer> sub=new ArrayList<>();
            for(int i:nums)
                sub.add(i);
            list.add(new ArrayList<>(sub));
            return;
        }
        for(int i=k;i<nums.length;i++){
            swap(nums,i,k);
            helper(nums,list,k+1);
            swap(nums,i,k);
        }
    }
    void swap(int nums[],int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}