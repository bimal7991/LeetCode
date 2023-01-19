class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            int rem=sum%k;
            if(rem<0)
                rem=rem+k;
            count=count+hm.getOrDefault(rem,0);
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        
        return count;
    }
}