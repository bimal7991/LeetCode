class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int m=potions.length;
        for(int i=0;i<n;i++){
            int v=binarySearch(spells[i],success,potions);
            spells[i]=  (v==-1)?0:m-v;
        }
        return spells;
    }
    int binarySearch(long sp,long success,int potions[])
    {
        int high=potions.length-1,low=0;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sp*potions[mid]>=success){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
}