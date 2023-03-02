class Solution {
    public int compress(char[] chars) {
        StringBuilder s=new StringBuilder();
        int count=1;
        char c=chars[0];
        for(int i=1;i<chars.length;i++){
            if(c==chars[i]){
                count++;
            }else{
                s.append(c);
                if(count!=1)
                s.append(""+count);
                c=chars[i];
                count=1;
            }
        }
        s.append(c);
        if(count!=1)
        s.append(""+count);
       char ans[]=s.toString().toCharArray();
        for(int i=0;i<ans.length;i++)
            chars[i]=ans[i];
        return ans.length;
        
    }
}