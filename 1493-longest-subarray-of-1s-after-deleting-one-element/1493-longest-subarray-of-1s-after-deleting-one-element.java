class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
               list.add(i);                
        }
        int prev=-1;
        int max=0;
        for(int i=0;i<list.size();i++){
            int cur=list.get(i);
            int next=nums.length;
            if(i+1<list.size())
            next=list.get(i+1);
            
            int val=cur-(prev+1)+(next-(cur+1));   
            max=Math.max(val,max);
            prev=cur;
        }
        if(list.size()<=1)
           return nums.length-1;
        return max;
    }
}