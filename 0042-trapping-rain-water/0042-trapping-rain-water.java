class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int sum=0,leftMax=0,rightMax=0;
        while(l<r){
            if(height[r]>height[l]){
                leftMax=Math.max(leftMax,height[l]);
                sum+=(leftMax-height[l]);
                l++;
            }
            else{
                rightMax=Math.max(rightMax,height[r]);
                sum+=(rightMax-height[r]);
                r--;
            }
        }
        return sum;
    }
}