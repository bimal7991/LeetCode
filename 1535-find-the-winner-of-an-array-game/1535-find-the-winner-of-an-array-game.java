class Solution {
    public int getWinner(int[] nums, int k) {
        int m=0;
        for(int i:nums)
            m=Math.max(m,i);
        int j=1;
        
        HashMap<Integer,Integer> hm=new LinkedHashMap<>();
        while(j<nums.length){
            if(nums[0]>nums[j]){
                hm.put(nums[0],hm.getOrDefault(nums[0],0)+1);
                j++;
            }
            else{
                nums[0]=nums[j];
                 hm.put(nums[0],hm.getOrDefault(nums[0],0)+1);
                j++;
            }
            if(hm.get(nums[0])==k)
                return nums[0];
        }
       
        return m;
    }
}