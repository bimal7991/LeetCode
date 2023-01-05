class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]==b[0]?Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]));
        // for(int arr[]:points){
        //     System.out.println(arr[0]+" "+arr[1]);
        // }
        int count=1;
        int start=points[0][1];
        for(int i=0;i<points.length;i++){
            if(points[i][0]<=start){
                start=Math.min(start,points[i][1]);
            }else{
                start=points[i][1];
                count++;
            }
        }
   
        return count;
    }
}