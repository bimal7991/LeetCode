class Solution {
    static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
        
        
        int arr[]=new int[26];
        if(s1.length()!=s2.length())
            return false;
        
        if(s1.length()==0)
            return true;
        
        if(s1.equals(s2))
            return true;
        
        int n=s1.length();
        
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s1.length();i++){
            arr[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0)
                return false;
        }
        String key=s1+" "+s2;
        if(mp.containsKey(key)){
            return mp.get(key);
            
        }
        boolean flag=false;
        
        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i),s2.substring(n-i,n)) && 
               isScramble(s1.substring(i,n),s2.substring(0,n-i))){
                flag=true;
                 return true;
            }
               
             if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,s1.length()),s2.substring(i,s2.length()))){
                   flag=true;
                 return true;              
 
             }
                
        }
        mp.put(key,flag);
        return flag;
        
    }
}