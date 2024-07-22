class Solution {
    public String[] sortPeople(String[] names, int[] height) {
        People arr[]=new People[names.length];
        for(int i=0;i<names.length;i++){
            arr[i]=new People(names[i],height[i]);
        }
        Arrays.sort(arr,(a,b)->b.height-a.height);
        String ans[]=new String[names.length];
        for(int i=0;i<names.length;i++){
            ans[i]=arr[i].name;
        }
        return ans;
    }
}
class People{
    String name;
    int height;
    People(String name,int height){
        this.name=name;
        this.height=height;
    }
    People(){}
}