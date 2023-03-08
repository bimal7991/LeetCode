class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i:piles){
            high=Math.max(high,i);
        }
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEat(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    boolean canEat(int piles[],int h,int mid){
        long count=0;
        for(int i:piles){
            int a=i/mid;
            if(i%mid!=0)
                a++;
            count=count+a;
        }
        return count<=h;
    }
}