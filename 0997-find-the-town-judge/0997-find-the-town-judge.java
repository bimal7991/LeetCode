class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[]=new int[n+1];
        for(int t[]:trust){
            arr[t[1]]++;
        }
        int ans=-1;
        for(int i=0;i<=n;i++){
            if(arr[i]==n-1)
                ans=i;
        }
     for(int t[]:trust){
            if(t[0]==ans)
                return -1;
        }
        return ans;
    }
}