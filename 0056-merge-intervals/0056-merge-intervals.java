class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr=new ArrayList<int[]>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=start && intervals[i][0]<=end){
                if(intervals[i][1]>=end){
                    end=intervals[i][1];
                }
            }
            else{
                arr.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        arr.add(new int[]{start,end});
        
        return arr.toArray(new int[0][]);
        
    }
}