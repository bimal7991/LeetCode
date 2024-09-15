public class Solution {
    public int FindTheLongestSubstring(string s) {
        Dictionary<int,int> dict=new Dictionary<int,int>();
        int bitmask=0;
        int max=0;
        dict.Add(0,-1);
        
        for(int i=0;i<s.Length;i++){
            char c=s[i];
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                bitmask=bitmask^(1<<(c-'a'));
            if(!dict.ContainsKey(bitmask))
                dict.Add(bitmask,i);
            int def;
            max=Math.Max(max,i-(dict.TryGetValue(bitmask,out def) ? def : 0));
        }
        return max;
    }
}