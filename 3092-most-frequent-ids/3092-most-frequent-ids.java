class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer, Long> hm = new TreeMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((a,b)->Long.compare(b.count, a.count));
        int max=0;
        long ans[]=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0L)+freq[i]);
            pq.add(new Pair(nums[i],hm.get(nums[i])));
            Pair curr=pq.peek();  
            while(hm.get(curr.id)!=curr.count){
                pq.poll();
                curr=pq.peek();
            }
            ans[i] = pq.peek().count;
        }
        return ans;
    }
    class Pair{
        int id;
        long count;
        Pair(int id,long count){
            this.id=id;
            this.count=count;
        }
    }
}