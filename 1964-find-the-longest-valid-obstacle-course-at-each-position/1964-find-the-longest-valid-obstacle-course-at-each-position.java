class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
         List<Integer> list=new ArrayList<Integer>();
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(list.isEmpty() || list.get(list.size()-1)<=nums[i]){
                list.add(nums[i]);
                ans[i]= i==0?1:list.size();
            }
            else{
                int index=binarySearch(list,nums[i]);
                list.set(index,nums[i]);
                ans[i]=index+1;
            }
        }
        return ans;
    }
    int binarySearch(List<Integer> list,int x){
        int low=0,high=list.size()-1;
        int index=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(list.get(mid)<=x){
                low=mid+1;
            }else{
                index=mid;
                high=mid-1;
            }
        }
        return index;
    }
}