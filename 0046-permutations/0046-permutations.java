class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        permutate(0,list,nums);
        return list;
    }
    void permutate(int index,  List<List<Integer>> list,int nums[]){
        if(index==nums.length){
            List<Integer> sub=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                sub.add(nums[i]);
            }
            list.add(new ArrayList<>(sub));
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            permutate(index+1,list,nums);
            swap(i,index,nums);
        }
        
        
    }
    void swap(int i,int j,int nums[]){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}