class Solution {
    public int maxLength(List<String> arr) {
        HashSet<String> s=new HashSet<String>();
        int ans[]=new int[1];
        helper(arr,s,ans,0);
        return ans[0];
    }
  void helper(List<String> arr,HashSet<String> s,int ans[],int j){
       
       int freq[]=new int[26];
       int flag=0;
       int len=0;
       for(String str:s){
           len=len+str.length();
           for(char c:str.toCharArray()){
               freq[c-'a']++;
               if(freq[c-'a']>1)
               {
                   return;
               } 
           }
       }
      
           ans[0]=Math.max(ans[0],len);
       //System.out.println(ans[0]);
      
       for(int i=j;i<arr.size();i++){
           s.add(arr.get(i));
           helper(arr,s,ans,i+1);
           s.remove(arr.get(i));    
       }
       
   }
}