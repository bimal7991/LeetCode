class Solution {
    public int appendCharacters(String s, String t) {
     int count=0;   
    // for(int i=0;i<t.length();i++){
    //    if(issubsequence(t.substring(0,i+1),s)){
    //        count=i+1;
    //    }
    // }
        int n = s.length(), m = t.length();
    int i = 0, j = 0;
    while (i < n && j < m) {
        if (s.charAt(i) == t.charAt(j))
            j++;
        i++;
    }
      // System.out.println(j);
    
        
        return t.length()-j;
        
    }
 boolean issubsequence(String s1, String s2)
{
    int n = s1.length(), m = s2.length();
    int i = 0, j = 0;
    while (i < n && j < m) {
        if (s1.charAt(i) == s2.charAt(j))
            i++;
        j++;
    }
    
    return i == n;
}
}