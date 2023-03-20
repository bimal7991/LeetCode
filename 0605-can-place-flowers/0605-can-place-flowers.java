class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int N=arr.length;
        if(N==1 && arr[0]==0)
            n--;
        
        for(int i=0;i<N;i++){
            if(i==0  && arr[i]==0 && i+1<N && arr[i+1]==0)
            {
                arr[i]=1;
                n--;
            }
            else if(i==N-1 && arr[i]==0 && i-1>=0 && arr[i-1]==0){
                arr[i]=1;
                n--;
            }
            else if(arr[i]==0 && i+1<N && i-1>=0 && arr[i+1]==0 && arr[i-1]==0)
            {
                arr[i]=1;
                n--;
            }
        }
        return n<=0;
    }
}