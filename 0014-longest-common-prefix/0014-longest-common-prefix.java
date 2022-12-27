class Solution {
    public String longestCommonPrefix(String[] strs) {
     
        String ans="";
        for(int i=1;i<=strs[0].length();i++){
            String prefix=strs[0].substring(0,i);
            int flag=0;
            for(int j=0;j<strs.length;j++){
                if(!strs[j].startsWith(prefix))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                ans=prefix;
        }
        return ans;
    }
}