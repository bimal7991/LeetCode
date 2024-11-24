class Solution {
    public int maxDistToClosest(int[] seats) {
        int index=-1;
        int diff=1;
        int prev=-1;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                if(prev==-1){
                    diff=Math.max(diff,i-prev-1);
                }
                else{
                int d=(i-prev);
                diff=Math.max(diff,d/2);    
                }
                prev=i;
            }
        }
        return Math.max(diff,seats.length-prev-1);
    }
}