class Solution {
    public int minimumPushes(String word) {
      int array[]=new int[26];
      for(char c:word.toCharArray()){
          array[c-'a']++;
      } 
      int arr[]=Arrays.stream(array).boxed()
    .sorted(Collections.reverseOrder())
    .mapToInt(Integer::intValue)
    .toArray();
      int sum=0;
      for(int i=0;i<26;i++){
          if(i<8){
              sum=sum+arr[i];
          }
          else if(i<16){
              sum=sum+(arr[i]*2);
          }
          else if(i<24){
              sum=sum+(arr[i]*3);
          }
          else
              sum=sum+(arr[i]*4);
      }
       return sum; 
    }
}