class MyCalendar {

    
    TreeMap<Integer,Integer> treemap;
    public MyCalendar() {
        treemap=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        treemap.put(start,treemap.getOrDefault(start,0)+1);
        treemap.put(end,treemap.getOrDefault(end,0)-1);
        int count=0;
        for(int key:treemap.keySet()){
            count+=treemap.get(key);
            if(count>1)
            {
                treemap.put(start,treemap.getOrDefault(start,0)-1);
                treemap.put(end,treemap.getOrDefault(end,0)+1);
                return false;
                
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */