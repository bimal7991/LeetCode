//{ Driver Code Starts
//Initial Template for Java
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
    	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    long ans=g.verticallyDownBST(root,target);
        	    out.println(ans);
                t--;
            
        }
        out.close();
    }
  
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    long verticallyDownBST(Node root,int target)
    {
        HashMap<Integer,LinkedList<Integer>> hm=new HashMap<>();
        Node node=getNode(root,target);
        if(node==null)
        return -1;
        helper(node,0,hm);
        long sum=0;
        LinkedList<Integer> li=hm.get(0);
        for(int j=1;j<li.size();j++)
        {
            sum=sum+li.get(j);
        }
        return sum;        
    }
    
    Node getNode(Node root,int target){
        
          if(root==null)
          return null;
         if(root.data==target)
          return root;
       
          if(root.data>target)
             return getNode(root.left,target);
           else       
          return getNode(root.right,target);
          
          
            
    }
    
    void helper(Node root,int i,HashMap<Integer,LinkedList<Integer>> hm){
        if(root==null)
         return ;
        if(hm.containsKey(i)){
            LinkedList<Integer> li=hm.get(i);
            li.add(root.data);
            hm.put(i,li);
        }
        else{
            LinkedList<Integer> li=new LinkedList<>();
             li.add(root.data);
            hm.put(i,li);
        }
        helper(root.left,i-1,hm);
        helper(root.right,i+1,hm);
         
    }
}