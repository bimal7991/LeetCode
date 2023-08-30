class Solution {
    public long minimumReplacement(int[] nums) {
        long count=0;
        int n=nums.length;
        int next=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>next){
                int t=nums[i]/next;
                if(nums[i]%next!=0){
                    t++;
                }
                next=nums[i]/t;
                count+=t-1;
            }
            else{
                next=nums[i];
            }
        }
       
        return count;
    }
}