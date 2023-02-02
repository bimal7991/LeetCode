class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<order.length();i++){
            hm.put(order.charAt(i),i);
        }
        int max=0;
        for(int k=0;k<words.length-1;k++){
            String cur=words[k];
            String next=words[k+1];
            int i=0;
            int j=0;
            while(i<cur.length() && j<next.length()){
                if(hm.get(cur.charAt(i))>hm.get(next.charAt(j)))
                    return false;
                else if(hm.get(cur.charAt(i))<hm.get(next.charAt(j)))
                {
                    break;
                }
                i++;
                j++;
            }
            if(j==next.length() && i!=cur.length())
                return false;
            
        }
        return true;
    }
}