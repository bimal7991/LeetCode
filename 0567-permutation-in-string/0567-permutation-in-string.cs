public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        Dictionary<char,int> dict1=new Dictionary<char,int>();
        foreach(char c in s1.ToCharArray()){
            if (dict1.ContainsKey(c)) {
                dict1[c]++;
            } else {
                dict1[c] = 1;
            }
        }
        int i=0,j=0;
        Dictionary<char,int> dict2=new Dictionary<char,int>();
        while(j<s2.Length){
            char c=s2[j];
            if (dict2.ContainsKey(c)) {
                dict2[c]++;
            } else {
                dict2[c] = 1;
            }
            while(dict2.GetValueOrDefault(c,0)>dict1.GetValueOrDefault(c,0)){
                char p=s2[i];
                dict2[p]--;
                if(dict2[p]==0)
                    dict2.Remove(p);
                i++;
                
            }
            if(AreDictionariesEqual(dict1,dict2))
                return true;
            j++;
        }
        return false;
    }
    bool AreDictionariesEqual(Dictionary<char, int> dict1, Dictionary<char, int> dict2) {
        if (dict1.Count != dict2.Count) return false;

        foreach (var kvp in dict1) {
            if (!dict2.ContainsKey(kvp.Key) || dict2[kvp.Key] != kvp.Value) {
                return false;
            }
        }

        return true;
    }
}