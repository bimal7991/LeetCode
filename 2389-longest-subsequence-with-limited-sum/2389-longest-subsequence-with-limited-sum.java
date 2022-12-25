class Solution {
    public int[] answerQueries(int[] nums, int[] q) {
        
    int[] res = new int[q.length];
    
	Arrays.sort(nums);
    for(int i=1; i<nums.length; i++)      
        nums[i] = nums[i] + nums[i-1];
    
    for(int i=0; i<q.length; i++)       
        res[i] = search(nums, q[i]);
    
    return res;
}

int search(int[] nums, int find){
    int left = 0, right = nums.length-1;
    int ind=-1;
    while(left<=right){
        int mid=(left+right)/2;
        if(nums[mid]<=find){
            ind=mid;
            left=mid+1;
        }
        else
            right=mid-1;
        
    } 
    return ind==-1?0:ind+1;
   
}
}