class Solution {
    public String largestOddNumber(String num) {
        int last=0;
        int i=num.length()-1;
        for(i=num.length()-1;i>=0;i--){
            if((num.charAt(i)-'0') %2==1)
                break;
        }  
        return num.substring(0,i+1);
    }
}