class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cube : cuboids) Arrays.sort(cube);
        Arrays.sort(cuboids,(a,b)->(a[0]+a[1]+a[2])-(b[0]+b[1]+b[2]));
        int n=cuboids.length;
        int heights[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            heights[i]=cuboids[i][2];
            max=Math.max(max,heights[i]);
           
        }
        for(int i=1;i<n;i++){
            int curr[]=cuboids[i];
            int h=heights[i];
            for(int j=0;j<i;j++){
                int st[]=cuboids[j];
                if(curr[0]>=st[0] && curr[1]>=st[1] && curr[2]>=st[2]){
                        heights[i]=Math.max(heights[i], curr[2]+heights[j]);
                        max=Math.max(max,heights[i]);
                        
                }
            }
        }
       // System.out.println(Arrays.toString(heights));
        return max;
    }
}