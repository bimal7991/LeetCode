class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int j=0;
        int count=0;
        int p=1;
        while(j<nums.length){
            p=p*nums[j];
            while(i<=j && p>=k){
                p=p/nums[i];
                i++;
            }
            count=count+(j-i+1);
            j++;
        }
        return count;
        
        
    }
}