class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            String s1=extend(s,i,i);
            String s2=extend(s,i,i+1);
            if(s1.length()>ans.length())
                ans=s1;
            if(s2.length()>ans.length())
                ans=s2;
        }
        return ans;
    }
    String extend(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}