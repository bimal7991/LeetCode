class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();
        for(int i:nums1){
            hs1.add(i);
        }
        for(int i:nums2){
            hs2.add(i);
        }
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int i:hs1){
            if(!hs2.contains(i)){
                list1.add(i);
            }
        }
        list.add(list1);
        for(int i:hs2){
            if(!hs1.contains(i)){
                list2.add(i);
            }
        }
        list.add(list2);
        return list;
        
    }
}