class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int count=0;
        for(int v:hm.values()){
            if(v==1)
                return -1;
            int c=v/3;
            if(v%3>=1)
                c++;
            count=count+c;   
        }
        return count;
    }
}