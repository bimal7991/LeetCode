class Solution {
    String ans="";
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        HashSet<String> hs=new HashSet<>();
        for(String s:nums){
            hs.add(s);
        }
        helper(n,new StringBuilder(""),hs);
        return ans;
    }
   void  helper(int n,StringBuilder sb,HashSet<String> set){
       
        if(sb.length()==n){
            if(!set.contains(sb.toString()))
                ans=sb.toString();
        }
       if(sb.length()>n)
           return;
        for(int i=0;i<=1;i++){
            sb.append(i);
            helper(n,sb,set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}