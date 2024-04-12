class Solution {
    public int trap(int[] height) {
        int suffix[]=new int[height.length];
        suffix[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],height[i]);
        }
        int max=height[0];
        int sum=0;
        for(int i=1;i<height.length-1;i++){
              sum=sum+ ((Math.min(max,suffix[i+1])-height[i])>0?(Math.min(max,suffix[i+1])-height[i]):0);
              max=Math.max(max,height[i]);
        }
        return sum;
    }
}