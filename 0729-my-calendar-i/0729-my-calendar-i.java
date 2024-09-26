class MyCalendar {

    
    TreeMap<Integer,Integer> treemap;
    public MyCalendar() {
        treemap=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey=treemap.floorKey(start);
        if(floorKey!=null && treemap.get(floorKey)>start)
            return false;
        Integer ceilingKey=treemap.ceilingKey(start);
        if(ceilingKey!=null && ceilingKey<end)
            return false;
        treemap.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */