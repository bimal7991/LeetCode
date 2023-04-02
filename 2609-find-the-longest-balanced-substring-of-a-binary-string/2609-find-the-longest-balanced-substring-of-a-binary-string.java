class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isBalanced(s.substring(i,j))){
                    max=Math.max(max,j-i);
                }
            }
        }
        return max;
    }
    boolean isBalanced(String s){
        if(s.length()%2!=0)
            return false;
        for(int i=1;i<s.length();i++){
           if(s.charAt(i)-'0'<s.charAt(i-1)-'0')
               return false;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='0')
               count++;
        }
        if(count!=s.length()/2)
            return false;
        return true;
    }
}