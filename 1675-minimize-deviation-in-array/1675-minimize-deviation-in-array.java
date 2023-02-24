class Solution {
    public int minimumDeviation(int[] nums) {
         int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
                nums[i]=2*nums[i];
            min=Math.min(min,nums[i]);
        }
     
       
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