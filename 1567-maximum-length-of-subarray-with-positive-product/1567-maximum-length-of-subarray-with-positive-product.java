class Solution {
    public int getMaxLen(int[] arr) {
       
        int neg=0;
        int max=0;
        int pos=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
               int t=pos;
               pos=neg==0?0:neg+1;
               neg=t+1; 
                
            }
            else if(arr[i]>0){
                pos++;
                neg= neg==0?neg:neg+1;
                
            }
            else{
               
                neg=0;
                pos=0;
            }
            max=Math.max(pos,max);
        }
        return max;
        
    }
}