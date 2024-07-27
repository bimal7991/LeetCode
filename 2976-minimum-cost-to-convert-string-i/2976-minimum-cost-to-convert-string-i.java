class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long arr[][]=new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
            arr[i][i]=0;
        }
        
        for(int i=0;i<original.length;i++){
            int src=original[i]-'a';
            int dest=changed[i]-'a';
            arr[src][dest]=Math.min(arr[src][dest],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int j=0;j<26;j++){
                for(int i=0;i<26;i++){
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            int src=source.charAt(i)-'a';
            int dest=target.charAt(i)-'a';
            if(src==dest)
                continue;
            if(arr[src][dest]==Integer.MAX_VALUE)
                return -1;
            ans+=arr[src][dest];
        }
        return ans;
        
        
    }
     
}