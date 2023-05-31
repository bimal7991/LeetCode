class UndergroundSystem {
     
    HashMap<Integer,Station> hm;
    HashMap<String,List<Integer>> map;
    public UndergroundSystem() {
        hm=new HashMap<>();
        map=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        hm.put(id,new Station(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
            Station temp=hm.get(id);
            hm.remove(id);
            int v=t-temp.time;
            String p=temp.name+"*"+stationName;
            if(map.containsKey(p)){
                List<Integer> list=map.get(p);
                list.add(v);
                map.put(p,list);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(v);
                map.put(p,list);
            }
    }
    
    public double getAverageTime(String start, String end) {
        String p=start+"*"+end;
        List<Integer> list=map.getOrDefault(p,new ArrayList<Integer>());
        double sum=0;
        for(Integer i:list){
            sum=sum+i;
        }
        if(list.size()==0)
            return 0;
        return sum/(double)list.size();
    }
}
class Station{
    String name;
    int time;
    Station(String n,int t){
        name=n;
        time=t;
    }
    Station(){}
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */