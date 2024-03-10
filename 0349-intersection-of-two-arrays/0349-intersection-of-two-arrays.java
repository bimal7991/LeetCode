class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums1)
            hs.add(i);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:nums2)
            if(hs.contains(i)){
                list.add(i);
                hs.remove(i);
            }
       return list.stream().mapToInt(Integer::intValue).toArray();
    }
}