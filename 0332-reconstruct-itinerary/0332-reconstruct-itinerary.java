class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map <String,List<Pair>> edges = new HashMap();  // From -> To List (each in ToList marked visited);
        for (List<String> ticket : tickets) {
            edges.putIfAbsent(ticket.get(0), new ArrayList<Pair>());
            edges.get(ticket.get(0)).add(new Pair(ticket.get(1) , false));
        }

        for (List<Pair> ToList : edges.values()) Collections.sort(ToList, (a,b) -> a.key.compareTo(b.key));

        Stack<String> itinerary = new Stack();
        itinerary.push ("JFK");
        return dfs (itinerary , 0 , tickets.size() , edges);
    }

    private List<String> dfs(Stack<String> itinerary , int ticketsUsed , int ticketsGoal, Map <String, List<Pair>> edges){
        if (ticketsUsed == ticketsGoal) return new ArrayList(itinerary);
        String cur = itinerary.peek();
        if (edges.get(cur) == null) return null;
        for (Pair next : edges.get(cur)){
            if (next.visited) continue; // used ticket
            next.visited = true;
            itinerary.push(next.key);
            List<String> res = dfs (itinerary, ticketsUsed + 1, ticketsGoal, edges);
            if (res != null) return res;
            itinerary.pop();
            next.visited = false;
        }
        return null;
    }

    class Pair{
        protected String key;
        protected Boolean visited;
        public Pair(String key, boolean visited){
            this.key = key;
            this.visited = visited;
        }
    }
}