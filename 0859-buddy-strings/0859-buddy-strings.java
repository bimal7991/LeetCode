class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        int count=0;
        int first=-1;
        int second=-1;
        int same=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i))
            {
                if(first==-1)
                first=i;
                else
                    second=i;
                
                count++;
            }
            
        }
        if(count==0){
            int arr[]=new int[26];
            for(char c:s.toCharArray()){
                arr[c-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                if(arr[i]>=2)
                    return true;
            }
            return false;
        }
            
        
        if(count!=2)
            return false;
         if(s.charAt(first)!=goal.charAt(second) || s.charAt(second)!=goal.charAt(first))
             return false;
        return true;
    }
}