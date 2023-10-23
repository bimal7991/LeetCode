class Solution {
    public boolean isPowerOfFour(int n) {
     
        int low=0;
        int high=32;
        while(low<=high){
            int mid=(low+high)/2;
            long v=(long)Math.pow(4,mid);
            if(v==n)
                return true;
            else if(v<n){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}