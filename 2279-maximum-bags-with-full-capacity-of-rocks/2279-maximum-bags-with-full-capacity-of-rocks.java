class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int a) {
        int n=capacity.length;
       int diff[]=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(diff);
        int i;
        for(i=0;i<n;i++){
            if(diff[i]==0)
                continue;
            if(a-diff[i]<0)
                break;
            a=a-diff[i];    
        }
        return i;
    }
}