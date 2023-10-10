class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int max=0;
        int diff=0;
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
            }
            j++;
        }
            return nums.length-max;   
    }
}