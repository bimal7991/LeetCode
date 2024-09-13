public class Solution {
    public int[] XorQueries(int[] arr, int[][] queries) {
        int[] prefix=new int[arr.Length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.Length;i++){
            prefix[i]=(arr[i]^prefix[i-1]);
        }
        // Console.WriteLine(string.Join(", ", prefix));
        int[] ans=new int[queries.Length];
        for(int i=0;i<queries.Length;i++){
            if(queries[i][0]==0)
              ans[i]=prefix[queries[i][1]];
            
            else
               ans[i]=prefix[queries[i][1]]^prefix[queries[i][0]-1];
        }
        return ans;
    }
}