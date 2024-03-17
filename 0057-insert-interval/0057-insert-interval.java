class Solution {
    public int[][] insert(int[][] intervals, int[] n) {
        List<int[]> arr=new ArrayList<>();
        int i=0;
        while(i<intervals.length && n[0]>intervals[i][1]){
            arr.add(intervals[i]);
            i++;
        }
        int start=n[0];
        int end=n[1];
        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(start,intervals[i][0]);
            end=Math.max(intervals[i][1],end);
            i++;
        }
        arr.add(new int[]{start,end});
        while(i<intervals.length){
            arr.add(intervals[i]);
            i++;
        }
        int ans[][]=new int[arr.size()][2];
        i=0;
        for(int a[]:arr){
            ans[i][0]=a[0];
            ans[i][1]=a[1];
            i++;
        }
        return ans;
        
    }
}