class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<Integer>();
        // List<Integer> st=new ArrayList<>();
        // st.add(12);st.add(123);st.add(1234);st.add(12345);st.add(123456);st.add(1234567);
        // st.add(12345678);st.add(123456789);
        int f=1;
        int k=11;
        for(int i=2;i<=9;i++){
            f=f*10+i;
            int n=f;
            if(n>=low && n<=high)
            list.add(n);
            for(int j=0;j<9-i;j++){
                n=n+k;
                if(n>=low && n<=high)
                list.add(n);
            }
            k=k*10+1;
        }
        
        
        
        return list;
    }
}