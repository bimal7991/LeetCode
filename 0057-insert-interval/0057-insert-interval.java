class Solution {
    public int[][] insert(int[][] intervals, int[] n) {
        ArrayList<int[]> list=new ArrayList<>();
        ArrayList<int[]> arr=new ArrayList<>();
        for(int inter[]:intervals){
            arr.add(inter);
        }
        arr.add(n);
        Collections.sort(arr,(a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int start=arr.get(0)[0];
        int end=arr.get(0)[1];
        
        for(int i=1;i<arr.size();i++){           
            if(arr.get(i)[0]>=start && arr.get(i)[0]<=end){
                end=Math.max(arr.get(i)[1],end);
            }
            else{
                list.add(new int[]{start,end});
                start=arr.get(i)[0];
                end=arr.get(i)[1];
            }
        }
          list.add(new int[]{start,end});
         
        
        return list.toArray(new int[0][0]);
        
    }
}