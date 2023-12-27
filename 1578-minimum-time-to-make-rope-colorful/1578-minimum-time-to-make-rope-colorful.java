class Solution {
    public int minCost(String col, int[] time) {
        int sum=0;
        int j=0;
        for(int i=1;i<col.length();i++){
            if(col.charAt(i)==col.charAt(j)){
                if(time[i]>time[j]){
                    sum=sum+time[j];
                    j=i;
                }else{
                    sum=sum+time[i];
                }
            }else{
                j=i;
            }
        }
        return sum;
    }
}