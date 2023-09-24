class Solution {
    public long maximumSumOfHeights(List<Integer> hm) {
          long suffix[]=getSuffix(hm);
          long prefix[]=getPrefix(hm);
        //System.out.println(Arrays.toString(prefix));
        //System.out.println(Arrays.toString(suffix));
        long max=0;
        for(int i=0;i<hm.size();i++){
            long ans=prefix[i]+suffix[i]-hm.get(i);
            max=Math.max(max,ans);
        }
        return max;
      }
   public long[] getPrefix(List<Integer> hm){
       Stack<Integer> st=new Stack<>();
       long nums[]=new long[hm.size()];
       for(int i=0;i<hm.size();i++){
            while(!st.isEmpty() && hm.get(i)<hm.get(st.peek())){
                st.pop();
            }
             if(st.isEmpty()){
                 nums[i]=(long)(i+1)*(long)hm.get(i);
             }else{
                 
                 nums[i]=nums[st.peek()]+ (long)(i-st.peek())*(long)hm.get(i);
             }
           st.push(i);
       }
       return nums;
   }
  public long[] getSuffix(List<Integer> hm){
       Stack<Integer> st=new Stack<>();
       long nums[]=new long[hm.size()];
       for(int i=hm.size()-1;i>=0;i--){
            while(!st.isEmpty() && hm.get(i)<hm.get(st.peek())){
                st.pop();
            }
             if(st.isEmpty()){
                 nums[i]=(long)(hm.size()-i)*(long)hm.get(i);
             }else{
                 long total=st.peek()-i;
                 nums[i]=nums[st.peek()]+(long)(total*hm.get(i));
             }
           st.push(i);
       }
       return nums;
   }
    
    
}