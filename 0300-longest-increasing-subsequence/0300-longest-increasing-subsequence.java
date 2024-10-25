class Solution {
    public int lengthOfLIS(int[] nums) {
        // int sort[]=new int[nums.length];
        // for(int i=0;i<nums.length;i++){
        //     sort[i]=nums[i];
        // }
        // Arrays.sort(nums);
        // return LCS(sort,nums); 
        // List<Integer> list=new ArrayList<Integer>();
        // for(int i=0;i<nums.length;i++){
        //     if(list.isEmpty() || list.get(list.size()-1)<nums[i]){
        //         list.add(nums[i]);
        //     }
        //     else{
        //         int index=binarySearch(list,nums[i]);
        //         list.set(index,nums[i]);
        //     }
        // }
        // return list.size();
        int max=1;
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
    int binarySearch(List<Integer> list,int x){
        int low=0,high=list.size()-1;
        int index=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(list.get(mid)<x){
                low=mid+1;
            }else{
                index=mid;
                high=mid-1;
            }
        }
        return index;
    }
    
    int LCS(int a[], int b[]){
        int n=a.length;
        int dp[][]=new int[n+1][n+1];
        int current=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){             
                if(a[i-1]==b[j-1] && (j<=1 || b[j-1]!=current)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                current=b[j-1];
            }
        }
        return dp[n][n];
    }
}