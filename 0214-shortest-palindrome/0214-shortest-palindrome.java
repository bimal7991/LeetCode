class Solution {
    public String shortestPalindrome(String s) {
        if(isPalindrome(s))
            return s;
        for(int i=s.length()-1;i>=1;i--){
            if(isPalindrome(s.substring(0,i)))
                return new StringBuilder(s.substring(i)).reverse().toString()+s;
        }
        return s+s;
    }
    boolean isPalindrome(String s){
        if(s.length()==1)
            return true;
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
               return false;
            i++;
            j--;
                
        }
        return true;
    }
}