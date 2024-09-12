public class Solution {
    public int CountConsistentStrings(string allowed, string[] words) {
        HashSet<char> hs=new HashSet<char>(allowed.ToCharArray());
        int count=0;
        foreach(string s in words){
            bool flag=true;
            foreach(char c in s.ToCharArray()){
                if(!hs.Contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                count++;
        }
        return count;
    }
}