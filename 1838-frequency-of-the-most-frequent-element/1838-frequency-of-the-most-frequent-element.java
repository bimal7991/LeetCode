class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        long sum=0;
        int max=0;
        while(j<nums.length){
           sum=sum+nums[j];
           while((j-i+1)*nums[j] -sum>k){
               sum=sum-nums[i];
               i++;
           }
           max=Math.max(max,j-i+1);
           j++; 
        }
        return max;
        
    }
    int canMost(int nums[],int k,int mid){
       int i=mid;
        for(i=mid;i>=0 && k-(nums[mid]-nums[i])>=0;i--){
            k=k-(nums[mid]-nums[i]);
        }
        return mid-i;
    }
}