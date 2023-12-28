class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[]=new int[nums1.length];
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> hm=new LinkedHashMap<>();
        int n=nums2.length-1;
        st.push(nums2[n]);
        hm.put(nums2[n],-1);
        for(int i=nums2.length-2;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                st.pop();
            }
            hm.put(nums2[i],st.isEmpty()?-1:st.peek());
            st.push(nums2[i]);
        }
        //System.out.println(hm);
        for(int i=0;i<nums1.length;i++){
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
    }
}