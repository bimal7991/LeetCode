class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<=s.length()/2;i++){
            String sub=s.substring(0,i);
            int j=i;
            while(j<=s.length()-i){
                if(sub.equals(s.substring(j,j+i))){
                    j=j+i;
                }
                else
                    break;
            }
           // System.out.println(j);
            if(j==s.length())
                return true;
        }
        return false;
        
    }
}