class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
       // System.out.println(Arrays.toString(nums));
        int mod=1000000007;
       
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= nums.length; ++i) {
            pre.add((pre.get(i - 1) << 1) % mod);
        }
        long sum=0;
         int i=0,j=nums.length-1;
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                sum=(sum+pre.get(j-i))%mod;
                i++;
            }
            else {
                j--;
            }
           
        }
        // System.out.println(i+" "+nums[i]);
        
        return (int)sum;
        
    }
}