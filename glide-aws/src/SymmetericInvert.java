import java.util.LinkedList;
import java.util.Queue;

public class SymmetericInvert {
	
	//right tree to left and left tree to right
	
	 public static boolean isSymmetric(TreeNode root) {
	        
	        //return isMirrorDFS(root , root);
	      return isMirrorBFS(root);
	        
	      
	        
	    }
	    //dfs
	    public static boolean isMirrorDFS(TreeNode t1 , TreeNode t2){
	        
	        if(t1 == null && t2 == null)
	            return true;
	        
	        if(t1 == null || t2 == null)
	            return false;
	        
	        if(t1.val != t2.val)
	            return false;
	        
	       return  isMirrorDFS(t1.left , t2.right) &&  isMirrorDFS(t1.right , t2.left);
	           
	        
	        
	        
	    }
	    
	    //bfs
	    
	    public static boolean isMirrorBFS(TreeNode root ){
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            TreeNode t1 = q.poll();
	            TreeNode t2 = q.poll();
	            
	            if(t1 == null && t2 == null) continue;
	            
	            if(t1 == null || t2 == null)
	                return false;
	            
	            if(t1.val != t2.val )
	                return false;
	            
	            q.add(t1.left);
	            q.add(t2.right);
	            q.add(t1.right);
	            q.add(t2.left);
	            
	            
	        }
	        return true;
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
