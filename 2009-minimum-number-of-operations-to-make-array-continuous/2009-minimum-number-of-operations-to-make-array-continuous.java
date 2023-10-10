class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int max=0;
        int diff=0;
        int first=0;
        int last=0;
       // System.out.println(Arrays.toString(nums));
        HashSet<Integer> set=new HashSet<>();
        while(j<nums.length){
            diff=nums[j]-nums[i];
            set.add(nums[j]);
            while(diff>nums.length-1){
                set.remove(nums[i]);
                i++;
                diff=nums[j]-nums[i];
            }
            if(diff<nums.length && set.size()>max)
            {
                max=set.size();
                first=i;
                last=j;
            }
            j++;
        }

      
     
            return nums.length-max;
        
        // System.out.println(Arrays.toString(nums));
        // while(low<=high){
        //     int mid=(low+high)/2;
        //     if(canMake(nums,mid)){
        //         ans=mid;
        //         high=mid-1;
        //     }
        //     else
        //         low=mid+1;
        // }
        
    }
    boolean canMake(int nums[],int mid){
        int count=0;
        int i=nums.length-1;
        while(nums[i]-nums[0]> (nums.length-1)){
            count++;
            i--;
        }
      while(i>=1){
          if(nums[i]==nums[i-1])
              count++;
          i--;
      }
        
        return count<=mid;
    }
}