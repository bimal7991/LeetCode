class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int count=0;
        int mult=1;
        while(j<n){
            mult=mult*nums[j];
            
            if(mult<k){
                count=count+(j+1-i);
            }
            else{
               while(mult>=k && i<=j){ 
                mult=mult/nums[i];
                i++;  
               }
                count=count+(j+1-i);
                   
            }
            j++;
           
        }
        return count;
    }
}