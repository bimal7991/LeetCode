class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> sub=new ArrayList<>();
         Set<List<Integer>> list=new HashSet<>();
          helper(0,sub,list,nums);
          return new ArrayList<>(list);                                
    }
    
    void helper(int index,List<Integer> sub,Set<List<Integer>> list,int nums[]){
        if(sub.size()>=2 ){
            list.add(new ArrayList<>(sub));
            
        }
        for(int i=index;i<nums.length;i++){
            if(sub.size()==0 || nums[i]>=sub.get(sub.size()-1)){
                 sub.add(nums[i]);
                helper(i+1,sub,list,nums);
                sub.remove(sub.size()-1);
            }
            
            
        }
       
    }
}