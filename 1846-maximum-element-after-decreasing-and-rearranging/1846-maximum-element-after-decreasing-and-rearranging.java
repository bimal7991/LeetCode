class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max=1;
        for(int i=0;i<arr.length;i++){
            if(arr[0]!=1)
                arr[0]=1;
            if(i>0){
                if(arr[i]-arr[i-1]>1){
                    arr[i]=arr[i-1]+1;
                }
            }
            max=Math.max(arr[i],max);
        }
        return max;
    }
}