class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int start[]=new int[flowers.length];
        int end[]=new int[flowers.length];
        for(int i=0;i<flowers.length;i++){
            start[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int ans[]=new int[people.length];
        for(int i=0;i<people.length;i++){
            int upper=findUpper(start,people[i]);
            int lower=findLower(end,people[i]);
            ans[i]=upper-lower;
        }
        return ans;
        
    }
    int findUpper(int nums[],int n){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=n){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    int findLower(int nums[],int n){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<n){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
}