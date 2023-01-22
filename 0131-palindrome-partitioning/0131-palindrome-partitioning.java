class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> sub =new ArrayList<>();
        helper(s,sub,ans,0);
        return ans;
    }
    
   void helper(String s, List<String> sub, List<List<String>>  ans,int ind){
        if(ind==s.length()){
            ans.add(new ArrayList<>(sub));
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s.substring(ind,i+1))){
                String p=s.substring(ind,i+1);
                sub.add(p);
                helper(s,sub,ans,i+1);
                sub.remove(sub.size()-1);
            }
        }
        
    }
     boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;          
            i++;
            j--;
        }
        return true;
    }
}