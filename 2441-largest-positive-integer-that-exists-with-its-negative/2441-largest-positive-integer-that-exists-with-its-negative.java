class Solution {
    public int findMaxK(int[] nums) {
        int max=-1;
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            if(i<0){
                hs.add(i);
            }
        }
        for(int i:nums){
            if(i>0 && hs.contains(-i)){
                  max=Math.max(i,max);
            }
        }
        return max;
    }
}