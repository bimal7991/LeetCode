class MyCalendarTwo {

    private TreeMap<Integer, Integer> treemap;    
    
    public MyCalendarTwo() {
        treemap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        treemap.put(start,treemap.getOrDefault(start,0)+1);
        treemap.put(end,treemap.getOrDefault(end,0)-1);
        int count=0;
        for(int key:treemap.keySet()){
            count+=treemap.get(key);
            if(count>2)
            {
                treemap.put(start,treemap.getOrDefault(start,0)-1);
                treemap.put(end,treemap.getOrDefault(end,0)+1);
                if(treemap.get(start)==0)
                    treemap.remove(start);
                if(treemap.get(end)==0)
                    treemap.remove(end);
                return false;
                
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */