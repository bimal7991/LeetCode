class Solution {
    public long maxRunTime(int n, int[] bat) {
        long sum=0;
        for(int i:bat)
            sum=sum+i;
        long low=0;
        long ans=0;
        long high=sum/n;
        while(low<=high){
            long mid=(low+high)/2;
            if(canRun(n,bat,mid)){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    boolean canRun(int n,int []bat,long mid){
        long limit=mid*n;
        long sum=0;
        for(int i:bat){
            if(i<mid)
                sum=sum+i;
            else
                sum=sum+mid;
                
        }
        return sum>=limit;
    }
}