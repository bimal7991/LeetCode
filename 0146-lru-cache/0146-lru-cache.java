class LRUCache {
    List<Pair> list;
    int c;
    HashMap<Integer,Integer> hm;
    public LRUCache(int capacity) {
        
        hm=new LinkedHashMap<>();
        c=capacity;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))
            return -1;
        int v=hm.get(key);
        hm.remove(key);
        hm.put(key,v);
        return v;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.remove(key);
            hm.put(key,value);
            return;
        }
        if(hm.size()==c){
           hm.remove(hm.entrySet().iterator().next().getKey());
        }
        
        hm.put(key,value);
    }
}
class Pair{
    int key,value;
    Pair(int k,int v){
        key=k;
        value=v;
    }
    Pair(){};
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */