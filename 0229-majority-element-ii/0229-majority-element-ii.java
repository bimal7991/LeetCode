class Solution {
    public List<Integer> majorityElement(int[] nums) {
   
       
        List<Integer> list=new ArrayList<Integer>();
       int count1=0;
       int count2=0;
        int ele1=-1,ele2=-1;
      
       for(int i=0;i<nums.length;i++){
           if(nums[i]==ele1){
               count1++;
           }
         
           else if(nums[i]==ele2){
            count2++;
           }
            else if(count1==0){
              ele1=nums[i];
              count1=1;  
          } 
           else if(count2==0){
               ele2=nums[i];
               count2=1;
           }
          else {
              count1--;
              count2--;
          }
             
       }
        //System.out.println(ele1+" "+ele2);
        int c1=0,c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                c1++;
            }
            else if(nums[i]==ele2){
            c2++;   
            }
        }
        if(c1>(nums.length/3))
            list.add(ele1);
        if(c2>(nums.length/3))
            list.add(ele2);
        
        return list;
    }
}