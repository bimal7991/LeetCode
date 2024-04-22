class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs=new HashSet<>();
        for(String s:deadends){
            hs.add(s);
        }
        if(hs.contains("0000"))
            return -1;
        int count=0;
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String p=q.poll();
                if(p.equals(target))
                    return count;
                for(int j=0;j<4;j++){
                    char ch[]=p.toCharArray();
                    if(ch[j]=='0')
                    {
                        ch[j]='9';
                        String m=new String(ch);
                        if(!hs.contains(m))
                            q.add(m);
                        hs.add(m);
                    }
                    else
                    {
                       ch[j]= (char)(ch[j]-1);
                       String m=new String(ch);
                       if(!hs.contains(m))
                            q.add(m);
                        hs.add(m);
                    }
                }
                for(int j=0;j<4;j++){
                    char ch[]=p.toCharArray();
                    if(ch[j]=='9')
                    {
                        ch[j]='0';
                        String m=new String(ch);
                        if(!hs.contains(m))
                            q.add(m);
                         hs.add(m);
                    }
                    else
                    {
                       ch[j]= (char)(ch[j]+1);
                       String m=new String(ch);
                       if(!hs.contains(m))
                            q.add(m);
                         hs.add(m);
                    }
                }
                
            }
             count++;
        }
        return -1;
    }
    
}