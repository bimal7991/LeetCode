class Solution {
    public String addBinary(String a, String b) {
        char arr1[]=a.toCharArray();
        char arr2[]=b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n=a.length()-1,m=b.length()-1;
        int c=0;
        while(n>=0 && m>=0){
            int sum=arr1[n]-'0'+arr2[m]-'0'+c;
            if(sum<2){
                sb.append(sum);
                c=0;
            }
            else if(sum==2){
                sb.append(0);
                c=1;
            }
            else if(sum==3){
                sb.append(1);
                c=1;
            }
            n--;
            m--;
        }
        while(n>=0){
            int sum=arr1[n]-'0'+c;
            if(sum<2){
                sb.append(sum);
                c=0;
            }
            else if(sum==2){
                sb.append(0);
                c=1;
            }
            else if(sum==3){
                sb.append(1);
                c=1;
            }
            n--;
        }
        while(m>=0){
            int sum=arr2[m]-'0'+c;
            if(sum<2){
                sb.append(sum);
                c=0;
            }
            else if(sum==2){
                sb.append(0);
                c=1;
            }
            else if(sum==3){
                sb.append(1);
                c=1;
            }
            m--;
        }
        if(c==1)
          sb.append(1);
        return sb.reverse().toString();
        
    }
}