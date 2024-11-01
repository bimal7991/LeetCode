class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int rightMax[]=new int[n];
        for(int i=n-1;i>=0;i--){
           rightMax[i]=(i==n-1)?height[i]:Math.max(rightMax[i+1],height[i]);
        }
        int sum=0;
       // System.out.println(Arrays.toString(rightMax));
        int leftMax=height[0];
        for(int i=1;i<n;i++){
            if((Math.min(leftMax,rightMax[i])-height[i])>=0)
            sum=sum+(Math.min(leftMax,rightMax[i])-height[i]);
            leftMax=Math.max(leftMax,height[i]);
            
        }
        return sum;
    }
}