class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int i=0,j=0;
        int min=cards.length+1;
        while(j<cards.length){
            if(hm.containsKey(cards[j])){
                min=Math.min(min,j-hm.get(cards[j])+1);
               // System.out.println(j+" "+i);
                int ind=hm.get(cards[j]);
                while( i<=ind){
                    hm.remove(cards[i]);
                    i++;
                }
            }
            hm.put(cards[j],j);
            j++;
        }
        return min==cards.length+1?-1:min;
    }
}