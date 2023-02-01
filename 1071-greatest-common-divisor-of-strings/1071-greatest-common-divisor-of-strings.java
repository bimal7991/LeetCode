class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ans="";
        for(int i=0;i<str1.length();i++){
            String s1=str1.substring(0,i+1);
            if(isGCD(str1,s1) && isGCD(str2,s1)){
                ans=s1;
            }
        }
        return ans;
    }
   boolean isGCD(String s1,String s2){
       int i=0;
       while(i+s2.length()<=s1.length() && s1.substring(i,i+s2.length()).equals(s2)){
           i=i+s2.length();
       }
       if(i==s1.length())
           return true;
       return false;
           
   }
}