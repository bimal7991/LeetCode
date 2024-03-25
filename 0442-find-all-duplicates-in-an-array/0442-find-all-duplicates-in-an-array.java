class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            int ind=Math.abs(i)-1;
            if(nums[ind]<0)
                list.add(Math.abs(i));
            else
            nums[ind]= -1*nums[ind];
        }
        return list;
    }
}