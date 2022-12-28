class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=0;
        if(digits[n-1]!=9){
            digits[n-1]=digits[n-1]+1;
            return digits;
        }else{
            int i=n-1;
            while(i>=0 && digits[i]==9 ){
                digits[i]=0;
                i--;
            }
            if(i!=-1){
                digits[i]=digits[i]+1;
                return digits;
            }
            else{
                int arr[]=new int[n+1];
                arr[0]=1;
                for(i=1;i<=n;i++)
                    arr[i]=digits[i-1];
                return arr;
            }
            
        }
    }
}