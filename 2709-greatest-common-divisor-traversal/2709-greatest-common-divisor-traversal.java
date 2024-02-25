class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if(nums.length==1)
            return true;
        if(nums[0]==1)
            return false;
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> arr[]=new ArrayList[100001];
        for(int i=0;i<100001;i++){
            arr[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> hs=primeFactors(nums[i]);
            for(int f:hs){
                arr[nums[i]].add(f);
                arr[f].add(nums[i]);
            }
            
        }
        
		Queue<Integer> queue=new LinkedList<Integer>();
        int vis[]=new int[100001];
 
		vis[nums[0]]=1;
		queue.add(nums[0]);
		//System.out.println(node);
		while(!queue.isEmpty()) {
			int curr=queue.peek();
			queue.remove();
			for(int child:arr[curr]) {
				if(vis[child]==0) {
					vis[child]=1;
					queue.add(child);
				}
			}
		}
        for(int i:nums){
            if(vis[i]==0)
                return false;
        }
        return true;
        
    }
    public HashSet<Integer> primeFactors(int n)
    {
        HashSet<Integer> hs=new HashSet<>();
        while (n%2==0)
        {
            hs.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        { 
            while (n%i == 0)
            {
                hs.add(i);
                n /= i;
            }
        }
 
        if (n > 2)
            hs.add(n);
        return hs;
    }
}