class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
    int atMostK(int nums[],int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0,j=0,count=0;
        while(j<nums.length){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size()>k){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i])==0)
                    hm.remove(nums[i]);
                i++;
            }
            count=count+j-i+1;
            j++;
        }
        return count;
    }
}