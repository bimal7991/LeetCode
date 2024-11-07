class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    left[i]=Math.max(left[i],1+left[j]);
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j])
                    right[i]=Math.max(right[i],1+right[j]);
            }
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
         //System.out.println(right);
        int max=n;
        for(int i=0;i<n;i++){
            if(left[i]==1 || right[i]==1)
            continue;
                max=Math.min(max,n-left[i]-right[i]+1);
        }
        return max;
    }
}