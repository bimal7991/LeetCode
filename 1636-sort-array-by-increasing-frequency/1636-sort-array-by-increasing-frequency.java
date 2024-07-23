class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
            list.add(i);
        }
        Collections.sort(list,(a,b)->hm.get(a)==hm.get(b)?b-a:hm.get(a)-hm.get(b));
        
        return list.stream().mapToInt(i->i).toArray();
    }
}