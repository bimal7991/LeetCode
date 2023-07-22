class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low=1;
        int high=m*n;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(countOf(mid,m,n)<k){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    int countOf(int limit,int m,int n){
        int count=0;
        for(int i=1;i<=m;i++){
            count+=Math.min(n,limit/i);
        }
        return count;
    }
}