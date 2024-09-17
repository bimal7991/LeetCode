public class Solution {
    public string[] UncommonFromSentences(string s1, string s2) {
        string[] arr1=s1.Split();
        String[] arr2=s2.Split();
        Dictionary<string,int> dict=new Dictionary<string,int>();
        foreach(string s in arr1){
            if(!dict.ContainsKey(s)){
                dict.Add(s,1);
            }else{
                dict[s]++;
            }
        }
        Dictionary<string,int> dict2=new Dictionary<string,int>();
        foreach(string s in arr2){
           if(!dict2.ContainsKey(s)){
                dict2.Add(s,1);
            }else{
                dict2[s]++;
            }
        }
         List<string> list=new List<string>();
        foreach (string key in dict.Keys)
        {
            if(dict[key]==1 && !dict2.ContainsKey(key))
               list.Add(key); 
        }
        foreach (string key in dict2.Keys)
        {
            if(dict2[key]==1 && !dict.ContainsKey(key))
               list.Add(key); 
        }
        return list.ToArray();
        
    }
}