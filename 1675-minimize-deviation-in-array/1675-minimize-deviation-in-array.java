class Solution {
    public int minimumDeviation(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
                nums[i]=2*nums[i];
        }
        Arrays.sort(nums);
        int min=nums[0];
        PriorityQueue<Integer> max=new PriorityQueue<Integer>((a,b)->b-a);
        for(int i:nums){
            max.add(i);
        }
        int diff=Integer.MAX_VALUE;
        
        while(max.peek()%2==0){
           
            diff=Math.min(diff,max.peek()-min);
            min=Math.min(max.peek()/2,min);
            max.add(max.poll()/2);
            
        }
        diff=Math.min(diff,max.peek()-min);
        return diff;
        
        
        
    }
}