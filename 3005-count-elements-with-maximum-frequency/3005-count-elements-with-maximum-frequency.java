class Solution {
    public int maxFrequencyElements(int[] nums) {
        int arr[]=new int[101];
        int max=0;
        int sum=0;
        for(int i:nums){
            arr[i]++;
            if(arr[i]>max){
                max=arr[i];
                sum=0;
            }
            if(arr[i]==max)
               sum+=arr[i]; 
        }
        
       
        return sum;
    }
}