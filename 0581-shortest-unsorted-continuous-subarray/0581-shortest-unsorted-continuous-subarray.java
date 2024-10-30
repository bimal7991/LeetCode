class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int min=nums[n-1];
        int start=-1,end=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=min)
                min=nums[i];
            else
                start=i;
        }
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>=max)
                max=nums[i];
            else
                end=i;
        }
        return (start==-1 || end==-1)?0:end-start+1;
       
    
        
    }
}