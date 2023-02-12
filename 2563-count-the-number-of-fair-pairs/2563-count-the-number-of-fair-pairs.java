class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
    int n = nums.length;
    Arrays.sort(nums);
    long count = 0;
    for (int i = 0; i < n; i++) {
        int target1 = lower-nums[i];
        int target2= upper-nums[i];
        int j = binarySearch(nums, i+1,n-1,target1);
        int k = binarySearch2(nums, i+1,n-1,target2);
        if(k!=-1 && j!=-1)
        count += k+1-j;
    }
    return count;
}

 int binarySearch(int[] nums, int left, int right,int target) {
    int ans=-1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid]>=target) {
            ans=mid;
            right=mid-1;
            
        } else {
            
            left = mid+1;
        }
    }
    return ans;
}
int binarySearch2(int[] nums, int left, int right,int target) {
    int ans=-1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid]<=target) {
            ans=mid;
            left=mid+1;
            
        } else {
            
            right = mid - 1;
        }
    }
    return ans;
  }
}