class Solution {
    public String countOfAtoms(String f) {
        Map<String,Integer> hm=new TreeMap<String,Integer>();
        Stack<String> st=new Stack<>();
        for(int i=0;i<f.length();i++){
            char c=f.charAt(i);
            if(c==')'){
                Stack<String> temp=new Stack<>();
                
                    int j=i+1;
                    int k=0;
                    while(j<f.length() && f.charAt(j)-'0'>=0 
                      && f.charAt(j)-'0'<=9){
                        k=k*10+f.charAt(j)-'0';
                        j++;
                    }
                if(k==0)
                    k=1;
                while(!st.peek().equals("(")){
                   String s=st.pop();
                   if(checkNumber(s)){
                       
                       int n=Integer.parseInt(s)*k;
                       temp.add(""+n);
                       temp.add(st.pop()) ;
                   }else{
                       temp.add(""+k);
                       temp.add(s);
                   }
                }
                st.pop();
                
                while(!temp.isEmpty()){
                    st.push(temp.pop());
                }
                i=j-1;
            }
            else{
                if(i+1<f.length() && Character.isLowerCase(f.charAt(i+1))){
                    String s=f.substring(i,i+2);
                    st.push(s);
                    i++;
                }
                else
                {
                    int j=i;
                    int num=0;
                    while(j<f.length() && f.charAt(j)-'0'>=0 
                      && f.charAt(j)-'0'<=9){
                        num=num*10+f.charAt(j)-'0';
                        j++;
                    }
                    if(num>0){
                        st.push(""+num);
                        i=j-1;
                    }
                    else
                    st.push(""+c);
                }
            }
        }
        while(!st.isEmpty()){
            String s=st.pop();
            if(checkNumber(s)){
                String key=st.pop();
                int n=Integer.parseInt(s);
                hm.put(key,hm.getOrDefault(key,0)+n);
            }
            else{
                hm.put(s,hm.getOrDefault(s,0)+1);
            }
        }
        StringBuilder s=new StringBuilder();
        for(String key:hm.keySet()){
            if(hm.get(key)>1)
            s.append(key+hm.get(key));
            else
                s.append(key);
        }
        return s.toString();
    }
    boolean checkNumber(String string){
        
        boolean numeric = true;

        try {
            Double num = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            numeric = false;
        }

        return numeric;
    }
}