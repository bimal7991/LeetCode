class Solution {
   public String removeKdigits(String s, int k) {
  Stack<Character> st=new Stack<>();
int i=0;
   for(i=0;i<s.length() && k>0 ;i++){
     char  c=s.charAt(i);
      while(!st.isEmpty()  && c-'0' <st.peek()-'0' && k>0)  {
              st.pop();
              k--;
      }
   st.push(c);
  }  
 while(!st.isEmpty() && k>0){
st.pop();
k--;
}
StringBuilder sb=new StringBuilder();
while(!st.isEmpty()){
sb.append(st.pop());
}
    String f=sb.reverse().toString()+s.substring(i);
       k=0;
for(k=0;k<f.length();k++)
    if(f.charAt(k)!='0')
    {
        break;
    }
       
return (f.substring(k)).equals("")?"0":f.substring(k); 

 
 }

}