class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int maxIndex=-1,swap1=-1,swap2=-1;
        for(int i=digits.length-1;i>=0;i--){
            if(maxIndex==-1 || digits[i]>digits[maxIndex]){
                maxIndex=i;
            }
            else if(digits[i]<digits[maxIndex]){
                swap1=maxIndex;
                swap2=i;
            }
        }
        if(swap1!=-1 && swap2!=-1){
        char t=digits[swap1];
        digits[swap1]=digits[swap2];
        digits[swap2]=t;
        }
        return Integer.parseInt(String.valueOf(digits));
    }
}