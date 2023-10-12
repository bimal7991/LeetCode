/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray m) {
         int mindex=0;
         int low=0;
         int high=m.length()-2;
         //finding peak element first and store it in mindex
         while(low<=high){
             int mid=(low+high)/2;
             if(m.get(mid)<m.get(mid+1)){
                 mindex=mid+1;
                 low=mid+1;
             }
             else
                 high=mid-1;
         }
          // mountain array -> increasing .... peakElement/mindex .........decreasing 
        
         low=0;
         high=mindex;
        // seacrh the target in increasing order in mountain array
         while(low<=high){
             int mid=(low+high)/2;
             if(m.get(mid)==target)
                 return mid;
              else if(m.get(mid)<target)
                  low=mid+1;
              else
                  high=mid-1;
         }
        // search the target in decreasing order in mountain array
         low=mindex;
         high=m.length()-1;
         while(low<=high){
             int mid=(low+high)/2;
             if(m.get(mid)==target)
                 return mid;
              else if(m.get(mid)<target)
                  high=mid-1;
              else
                  low=mid+1;
         }
        return -1;
        
    }
}