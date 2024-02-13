class Solution {
    public String firstPalindrome(String[] words) {
        for(String s:words){
            if(checkPalindrome(s))
                return s;
        }
        return "";
    }
    boolean checkPalindrome(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}