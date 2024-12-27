class Solution {
    int max=0;
    public int maxScoreSightseeingPair(int[] prices) {
        
        // int max1=0;
        int max=0;
        int max2=prices[0]+0;
        for(int i=1;i<prices.length;i++){
            int max1=prices[i]-i;
            // System.out.println(max1+" "+max2);
            max=Math.max(max1+max2,max);
            max2=Math.max(max2,prices[i]+i);
        }
        return max;
        
    }
}
//     int helper(int i,int nums[],boolean flag){
        
        
//         // if(flag){
//         //      int inc=nums[i]+i+helper(i+1,nums,!flag);
//         //      int exc=helper(i+1,nums,!flag);
//         // }
//         // else{
//         //     int inc=nums[i]-i+helper(i+1,nums,!flag);
//         //     int exc=helper(i+1,nums,!flag);
//         //     max=Math.max(inc,exc)
//         // }
              
          
//     }
// }