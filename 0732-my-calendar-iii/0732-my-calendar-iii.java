class MyCalendarThree {

    TreeMap<Integer,Integer> treemap;
    public MyCalendarThree() {
        treemap=new TreeMap<>();
    }
    
    public int book(int start, int end) {
        treemap.put(start,treemap.getOrDefault(start,0)+1);
        treemap.put(end,treemap.getOrDefault(end,0)-1);
        int count=0;
        int max=0;
        for(int key:treemap.keySet()){
            count+=treemap.get(key);
            max=Math.max(max,count);
            // System.out.println(max);
            
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */