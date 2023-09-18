class Solution {
    public long minimumReplacement(int[] nums) {
        long count=0;
        int n=nums.length;
        int next=nums[n-1];
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]>next){
                if(nums[i]%next==0){
                    count=count+(nums[i]/next)-1;
                    nums[i]=next;
                }
                else{
                    int d=nums[i]/next;
                    count=count+d;
                    next=nums[i]/(d+1);
                }
            }
            else
                next=nums[i];
        }
        return count;
    }
}