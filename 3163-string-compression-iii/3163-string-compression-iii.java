class Solution {
    public String compressedString(String s) {
        StringBuilder ans=new StringBuilder();
    char prev=s.charAt(0);
    int count=1;
    for(int i=1;i<s.length();i++){
          if(prev==s.charAt(i)){
            count++;
            if(count==10)
            {
              ans.append("9"+prev);
              count=1;
            }
          }
      else{
          ans.append(""+count+prev);
          count=1;
          prev=s.charAt(i);
      }  
    }
    if(count>=1)
      ans.append(""+count+prev);
    return ans.toString();
    }
}