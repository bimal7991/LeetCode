class Solution {
    public long minimumTime(int[] time, int total) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i:time){
            min=Math.min(i,min);
            max=Math.max(i,max);
        }
        long high=(long)min*(long)total;
        long low=1;
        long ans=0;
        while(low<=high){
            long mid=(low+high)/2;
            long count=0;
            for(int i=0;i<time.length;i++){
                count=count+(mid/time[i]);
            }
            if(count>=total){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
}