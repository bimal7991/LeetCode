class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int low=0;
        int high=arr.length-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]-(mid+1)>=k){
                high=mid-1;
            }
            else{
                 ans=mid;
                low=mid+1;
            }
        }
        return low+k;
    }
}