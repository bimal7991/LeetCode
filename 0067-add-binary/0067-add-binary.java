class Solution {
    public String addBinary(String a, String b) {
        char arr1[]=a.toCharArray();
        char arr2[]=b.toCharArray();
        ArrayList<Character> ch=new ArrayList<>();
        int c=0;
        int n=a.length()-1,m=b.length()-1;
        while(n>=0 && m>=0){
            int sum=arr1[n]-'0'+arr2[m]-'0'+c;
            if(sum<2){
                ch.add((char)(sum+'0'));
                c=0;
            }
            else if(sum==2){
                ch.add('0');
                c=1;
            }
            else if(sum==3){
                ch.add('1');
                c=1;
            }
            n--;
            m--;
        }
        while(n>=0){
            int sum=arr1[n]-'0'+c;
            if(sum<2){
                ch.add((char)(sum+'0'));
                c=0;
            }
            else if(sum==2){
                ch.add('0');
                c=1;
            }
            else if(sum==3){
                ch.add('1');
                c=1;
            }
            n--;
        }
        while(m>=0){
            int sum=arr2[m]-'0'+c;
            if(sum<2){
                ch.add((char)(sum+'0'));
                c=0;
            }
            else if(sum==2){
                ch.add('0');
                c=1;
            }
            else if(sum==3){
                ch.add('1');
                c=1;
            }
            m--;
        }
        if(c==1)
            ch.add('1');
        Collections.reverse(ch);
        StringBuilder sb = new StringBuilder();
 
        // Appends characters one by one
        for (Character c1 : ch) {
            sb.append(c1);
        }
        
        return sb.toString();
        
    }
}