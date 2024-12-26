class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> hm=new HashMap<>();
        return compute(nums,target,0,0,hm);
    }
    int compute(int nums[],int target, int i,int sum, HashMap<String,Integer> hm){
        if(i==nums.length && sum==target){
            return 1;
        }
        if(i>=nums.length){
            return 0;
        }
        String key=" "+i+"*"+sum;
        if(hm.containsKey(key))
            return hm.get(key);
        int add=compute(nums,target,i+1,sum+nums[i],hm);
        int sub=compute(nums,target,i+1,sum-nums[i],hm);
        hm.put(key,add+sub);
        return add+sub;
    }
}