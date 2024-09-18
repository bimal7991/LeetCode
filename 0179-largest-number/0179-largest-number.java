class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i:nums){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
        public int compare(Integer a, Integer b) {
        String s1=Integer.toString(a); 
        String s2=Integer.toString(b);
        s1=s1+s1;
        s2=s2+s2;    
        if(s1.length()>s2.length()){
            int t=s1.length()/s2.length();
            int rem=s1.length()%s2.length();
            StringBuilder str=new StringBuilder();
            for(int i=0;i<t;i++)
                str.append(s2);
            str.append(s2);
            s2=str.toString();      
        }
               
        else if(s1.length()<s2.length()){
            int t=s2.length()/s1.length();
            int rem=s2.length()%s1.length();
            StringBuilder str=new StringBuilder();
            for(int i=0;i<t;i++)
                str.append(s1);
            str.append(s1);
            s1=str.toString();      
        }     
        int i=0,j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else if(s1.charAt(i)-'0'>s2.charAt(j)-'0')
                return -1;
            else
                return 1;
        }
        return 0;
        }
        });
        // System.out.println(list);    
        StringBuilder s=new StringBuilder();
        for(int i:list){
            s.append(i);
        }
        int k=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                k=i;
            else
                break;
        }
        
        return s.toString().substring(k);
    }
}