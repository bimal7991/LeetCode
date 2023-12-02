class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int arr[]=new int[26];
        for(char c:p.toCharArray()){
            arr[c-'a']++;
        }
       // System.out.println(Arrays.toString(arr));
        int i=0,j=0;
        List<Integer> ans=new ArrayList<>();
        int sub[]=new int[26];
        while(j<s.length() && i<=j){
            if(j-i+1<p.length()){
                sub[s.charAt(j)-'a']++;
                j++;
                
            }
            else if(j-i+1==p.length()){
                sub[s.charAt(j)-'a']++;
                if(Arrays.equals(sub.clone(),arr)){
                    ans.add(i);
                }
                sub[s.charAt(i)-'a']--;
                i++;
                j++;
            }
        }
        return ans;
    }
}