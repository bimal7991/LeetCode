class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int dp[]=new int[nums.length];
        int size=1;
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                    size=Math.max(size,dp[i]);
                }
            }
        }
       
        // System.out.println(Arrays.toString(dp));
        
        return  constructLDS(nums,dp,size);
        
    }
   public List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
	var prev = -1;
	var lds = new LinkedList<Integer>();

	for (var i = dp.length - 1; i >= 0; i--)
		if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
			lds.addFirst(nums[i]);
			ldsSize--;
			prev = nums[i];
		}

	return lds;
  }
    
}