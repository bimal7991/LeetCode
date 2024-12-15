class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Double.compare((double)(b[0]+1)/(b[1]+1)-(double)b[0]/b[1],(double)(a[0]+1)/(a[1]+1)-(double)a[0]/a[1]));
        for(int arr[]:classes){
            pq.add(arr);
        }
        double d=0; 
        while(extraStudents>0){
            int arr[]=pq.poll();
            pq.add(new int[]{arr[0]+1,arr[1]+1});
            extraStudents--;
        }
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            d=d+((double)arr[0]/(double)arr[1]);
        }
        return d/(double)classes.length;
        
    }
}