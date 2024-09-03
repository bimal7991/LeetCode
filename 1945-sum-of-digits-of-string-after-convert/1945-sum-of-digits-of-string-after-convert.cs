public class Solution {
    public int GetLucky(string s, int k) {
           int sum=0;
          int n=0;
           foreach(var c in s.ToCharArray()){
                n=c-'a'+1;
               if(n>9)
                   sum=sum+n/10;
               sum=sum+n%10;
           }
          k--;
          while(k>0){
              n=0;
              while(sum>0){
                  n=n+(sum%10);
                  sum=sum/10;
              }
              sum=n;
              k--;
          }
        return sum;
    }
}