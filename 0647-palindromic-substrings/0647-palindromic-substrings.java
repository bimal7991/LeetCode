class Solution {
    int count=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            extend(s,i,i);
            extend(s,i,i+1);
        }
        return count;
    }
    public void extend(String s,int i,int j){
         while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j) ){
                 count++;
                 i--;
                 j++;
             
         }
    }
}