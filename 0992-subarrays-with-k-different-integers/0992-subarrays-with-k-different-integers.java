class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0,j=0,count1=0,count2=0;
        while(j<nums.length){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size()>k){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i])==0)
                    hm.remove(nums[i]);
                i++;
            }
            count1=count1+j-i+1;
            j++;
        }
        hm.clear();
        // System.out.println(hm);
        j=0;i=0;
         while(j<nums.length){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size()>=k){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i])==0)
                    hm.remove(nums[i]);
                i++;
            }
            count2=count2+j-i+1;
            j++;
        }
        
        return count1-count2;
        
    }
}