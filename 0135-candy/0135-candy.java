class Solution {
    public int candy(int[] rat) {
        int n=rat.length;
        int arr[]=new int[n];
        int count=0;
        Arrays.fill(arr,1);
        for(int i=1;i<n;i++){
            if(rat[i]>rat[i-1]){
                arr[i]=arr[i-1]+1;
            }
            
        }
        for(int i=n-2;i>=0;i--){
            if(rat[i]>rat[i+1]){
                arr[i]=Math.max(arr[i],arr[i+1]+1);
            }
        }
        int sum=0;
        for(int I:arr)
            sum=sum+I;
        return sum;
    }
        
}