class Solution {
    public String maximumOddBinaryNumber(String s) {
        char arr[]=new char[s.length()];
        Arrays.fill(arr,'0');
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                count++;
        }
        int n=s.length()-1;
        if(count>=1)
            arr[n]='1';  //setting least significant bit to '1'
        count--;
        int j=0;
        while(j<n && count>0){
            arr[j]='1';
            count--;
            j++;
        }
        return new String(arr);
        
    }
}