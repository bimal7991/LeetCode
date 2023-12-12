class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(j<nums.length){
            if(hm.containsKey(nums[j])){
                while(hm.containsKey(nums[j])){
                    sum=sum-nums[i];
                    hm.remove(nums[i]);
                    i++;
                }
            }
            sum=sum+nums[j];
            hm.put(nums[j],j);
            max=Math.max(sum,max);
            j++;
        }
        return max;
    }
}