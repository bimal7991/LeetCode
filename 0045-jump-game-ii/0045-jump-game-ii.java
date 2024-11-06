class Solution {
    public int jump(int[] nums) {
        int begin=0,end=0,count=0;
        for(int i=0;i<nums.length-1;i++){
            end=Math.max(end,i+nums[i]);
            if(i==begin){
                count++;
                begin=end;
            }
            
        }
        return count;
        
    }
    int helper(int index,int nums[]){
        if(index>=nums.length-1)
            return 0;
        int min=Integer.MAX_VALUE-1;
        for(int i=1;i<=nums[index];i++){
            min=Math.min(1+helper(index+i,nums),min);
        }
        return min;
    }
}