class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int level=1;
        Set<String> visited=new HashSet<>();
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String str=q.poll();
                if(str.equals(endWord))
                    return level;
                for(int j=0;j<str.length();j++){
                    for(char c='a';c<='z';c++){
                        char arr[]=str.toCharArray();
                        arr[j]=c;
                        String ns=new String(arr);
                         
                        if(hs.contains(ns) && !visited.contains(ns)){
                            q.add(ns);
                            visited.add(ns);
                        }
                    }
                }
                
            }
            level++;
        }
        return 0;
        

    }
}


