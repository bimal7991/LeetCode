/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> level=new HashMap<>();
    HashMap<Integer,Integer> height=new HashMap<>();
    HashMap<Integer,int[]> max2Level=new HashMap<>();
    public int[] treeQueries(TreeNode root, int[] queries) {
           helper(root,0);
        //    System.out.println(level);
        // System.out.println(height);
           int ans[]=new int[queries.length];
           for(int i=0;i<queries.length;i++){
               int l=level.get(queries[i]);
               int arr[]=max2Level.get(l);
               if(arr[0]==height.get(queries[i])){
                   ans[i]=l-1 +arr[1];
               }
               else
                   ans[i]=l+arr[0]-1;
           }
        return ans;
    }
    public int helper(TreeNode root,int lev){
        if(root==null)
            return 0;
        level.put(root.val,lev);
        int l=helper(root.left,lev+1);
        int r=helper(root.right,lev+1);
        
        int max=Math.max(l,r);
        height.put(root.val,max+1);
        if(max2Level.containsKey(lev)){
            int arr[]=max2Level.get(lev);
            if(max+1>arr[0])
            {   int t=arr[0];
                arr[1]=t;
                arr[0]=max+1;
            }
            else if(max+1>arr[1]){
                arr[1]=max+1;
            }
            max2Level.put(lev,arr);
        }
        else{
            max2Level.put(lev,new int[]{max+1,0});
        }
        
        return max+1;
        
    }
}