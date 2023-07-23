class Solution {
    public int maxIncreasingGroups(List<Integer> limit) {
        int low=0;
        int high=limit.size();
        long prefix[]=new long[high];
        Collections.sort(limit);
        prefix[0]=limit.get(0);
        for(int i=1;i<high;i++){
            prefix[i]=prefix[i-1]+limit.get(i);
        }
        
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(canGroup(prefix,mid)){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    boolean canGroup(long prefix[],int mid){
        
        for(int i=prefix.length-1;i>=0;i--){
            if(mid==0)
                return true;
            long res=((long)mid*(long)(mid+1))/2;
            if(prefix[i]<res)
                return false;
            mid--;
        }
        return true;
    }
}