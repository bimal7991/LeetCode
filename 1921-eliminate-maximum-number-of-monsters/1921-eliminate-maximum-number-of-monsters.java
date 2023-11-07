class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        int time[]=new int[n];
        for(int i=0;i<n;i++){
            time[i]=dist[i]%speed[i]==0?dist[i]/speed[i]:dist[i]/speed[i]+1;
        }
        Arrays.sort(time);
        int k=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(time[i]>k){
                count++;
                k++;
            }
            else
                break;
        }
        return count;
    }
}