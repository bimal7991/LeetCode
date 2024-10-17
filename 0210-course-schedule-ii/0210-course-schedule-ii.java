class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list=new ArrayList<>();
        int indegree[]=new int[numCourses];
        List<Integer> arr[]=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            arr[i]=new ArrayList<>();
        for(int a[]:prerequisites){
            indegree[a[0]]++;
            arr[a[1]].add(a[0]);
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
                list.add(i);
            }
                
        }
        while(!queue.isEmpty()){
            int a=queue.poll();
            for(int i:arr[a]){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.add(i);
                    list.add(i);
                }
            }
        }
         for(int i=0;i<numCourses;i++){
            if(indegree[i]!=0)
                return new int[]{};
        }
        //Collections.reverse(list);
        
        return list.stream().mapToInt(Integer::intValue)
                                    .toArray();
    }
}