class Solution {
    int max=0;
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
       //  int min=Integer.MIN_VALUE;
       //  HashMap<String,Integer> hm=new HashMap<>();
       // int a=helper(min,min,0,intervals,hm);
       // //System.out.println(a);
       //  return intervals.length-a;
        int count=0;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                count++;
                end=Math.min(end,intervals[i][1]);
            }else{
                end=intervals[i][1];
            }
        }
        return count;
    }
//     int helper(int start,int end,int index,int[][] intervals,HashMap<String,Integer> hm){
//         if(index==intervals.length)
//             return 0;
//         String key=" "+start+" "+end;
//         if(hm.containsKey(key))
//             return hm.get(key);
//         if(intervals[index][0]>=end){
//             int a=Math.max(1+helper(intervals[index][0],intervals[index][1],index+1,intervals,hm),helper(start,end,index+1,intervals,hm));
//             hm.put(key,a);
//             return a;
//         }
//         else{
//             int b=helper(start,end,index+1,intervals,hm);
//             hm.put(key,b);
//             return b;
//         }
        
//     }
}