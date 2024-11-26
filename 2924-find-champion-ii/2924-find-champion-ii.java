class Solution {
    public int findChampion(int n, int[][] edges) {
        int inDegree[]=new int[n];
        for(int e[]:edges){
            inDegree[e[1]]++;
        }
        int count=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                ans=i;
                count++;
            }
        }
        return count>=2?-1:ans;
    }
}