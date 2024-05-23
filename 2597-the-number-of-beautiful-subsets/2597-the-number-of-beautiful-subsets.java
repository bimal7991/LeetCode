class Solution {
    int count=0;
    public int beautifulSubsets(int[] nums, int k) {
        helper(nums,0,k,new ArrayList<>());
        return count-1;
    }
    void helper(int nums[],int i,int k,ArrayList<Integer> sub){
        if(i==nums.length){
            count++;
            return;
        }
        if(canAdd(sub,nums[i],k)){
            sub.add(nums[i]);
            helper(nums,i+1,k,sub);
            sub.remove(sub.size()-1);
            helper(nums,i+1,k,sub);
        }else{
            helper(nums,i+1,k,sub);
        }
    }
    boolean canAdd(ArrayList<Integer> sub,int n,int k){
        for(int i:sub){
            if(Math.abs(i-n)==k)
                return false;
        }
        return true;
    }
    
}