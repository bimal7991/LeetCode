class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low=1;
        int high=0;
        for(int i: quantities){
            high=Math.max(high,i);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(canDistribute(mid,quantities,n)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
   public boolean canDistribute(int mid,int quantites[],int n){
       int count=0;
       for(int q:quantites){
           count=count+(q/mid);
           if(q%mid!=0)
               count++;
       }
       if(count>n)
           return false;
       return true;
   } 
    
}