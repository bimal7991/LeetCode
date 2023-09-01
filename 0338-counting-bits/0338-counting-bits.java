class Solution {
    public int[] countBits(int n) {
        int count=0;
        int arr[]=new int[n+1];
        for(int j=0;j<=n;j++){
            count=0;
        for(int i=0;i<32;i++){
            if(((j>>i) & 1)==1)
                count++;
        }
            arr[j]=count;
        }
        return arr;
    }
}