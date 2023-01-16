class Solution {
    public int[][] insert(int[][] intervals, int[] n) {
        ArrayList<int[]> list=new ArrayList<>();
        
        
        int i=0;
        while(i<intervals.length && n[0]>intervals[i][1]){
            list.add(intervals[i++]);
        }
        
        while(i<intervals.length && n[1]>=intervals[i][0]  ){           
            
                n[0]=Math.min(n[0],intervals[i][0]);
                n[1]=Math.max(n[1],intervals[i][1]);
               i++;
            }
        
         list.add(n);
         while(i<intervals.length){
             list.add(intervals[i++]);
         }
        
        return list.toArray(new int[0][0]);
        
    }
}