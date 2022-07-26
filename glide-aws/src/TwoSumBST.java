import java.util.ArrayList;
import java.util.List;



/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 * @author midhula.kadiyala
 *
 */
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val) {this.val = val;}
	
	
}
public class TwoSumBST {
	
//	Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//			Example 1:
//
//			Input: 
//			    5
//			   / \
//			  3   6
//			 / \   \
//			2   4   7
//
//			Target = 9
//
//			Output: True
//			 
//
//			Example 2:
//
//			Input: 
//			    5
//			   / \
//			  3   6
//			 / \   \
//			2   4   7
//
//			Target = 28
//
//			Output: False
	
	public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root , list);
        
        int l=0 , r = list.size()-1;
        
        while(l < r){
            
            int sum = list.get(l) + list.get(r);
            
            if(sum == k)
                return true;
            if(sum < k)
             l++;
            
            else
                r--;
            
            
        }
        return false;
    }
    
    public void inorder(TreeNode root , List<Integer> list){
        
        if(root == null)
            return;
        
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
