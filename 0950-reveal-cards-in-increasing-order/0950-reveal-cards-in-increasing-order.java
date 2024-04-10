class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
       Arrays.sort(deck);
       int ans[]=new int[deck.length];
       int count=0,i=0,k=0;
       int r=1;
       boolean skip=false;
       while(count!=deck.length){
           if(ans[i]!=0)
           {
               i++;
               if(i==deck.length){
                    i=0;
                }
               continue;
           }
            if(skip==false){
                ans[i++]=deck[k++];
                skip=true;
                count++;
                if(i==deck.length){
                    i=0;
                }
            }
           else{
               i++;
               skip=false;
               if(i==deck.length){
                    i=0;
                }
           }
           // System.out.println(Arrays.toString(ans));
       }
        return ans;
    }
}