class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[]=new int[n+1];
        for(int t[]:trust){
            arr[t[1]]++;
            arr[t[0]]--;
        }
        int ans=-1;
        for(int i=0;i<=n;i++){
            if(arr[i]==n-1)
                ans=i;
        }
       return ans;
    }
}