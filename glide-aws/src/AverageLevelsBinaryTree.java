import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {
	
	 public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> result = new ArrayList<>();
	        Queue<TreeNode> q = new LinkedList<TreeNode> ();  
	    q.add(root);  
	    long sum = 0, count  = 0; 
	  
	    while (!q.isEmpty()) {  
	  
	        // Compute sum of nodes and  
	        // count of nodes in current  
	        // level.  
	        sum = 0; 
	        count = 0;  
	        Queue<TreeNode> temp = new LinkedList<TreeNode> ();  
	        while (!q.isEmpty()) {  
	            TreeNode n = q.peek();  
	            q.remove();  
	            sum += n.val;  
	            count++;  
	            if (n.left != null)  
	                temp.add(n.left);  
	            if (n.right != null)  
	                temp.add(n.right);  
	        }  
	        q = temp;  
	        result.add((sum * 1.0 / count));
	        System.out.print((sum * 1.0 / count) + " ");  
	    }  
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
