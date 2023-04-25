class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> hs;
    public SmallestInfiniteSet() {
        pq=new PriorityQueue<>();
        hs=new HashSet<>();
        for(int i=1;i<=10000;i++)
        {
            pq.add(i);
            hs.add(i);
        }
    }
    
    public int popSmallest() {
        int a=pq.poll();
        hs.remove(a);
        return a;
    }
    
    public void addBack(int num) {
        if(!hs.contains(num)){
            hs.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */