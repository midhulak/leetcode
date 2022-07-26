import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigZagLevelOrder {
	
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	       if(root == null) return new ArrayList();
	            List<List<Integer>> result = new ArrayList();
	            Queue<TreeNode> q = new LinkedList();
	            q.add(root);
	            boolean reverseLevel = false;

	            while(!q.isEmpty()) {
	                int size = q.size();
	                List<Integer> level = new ArrayList();
	                for(int i=0 ; i<size; i++) {
	                    root = q.remove();
	                    level.add(root.val);
	                    
	                    if(root.left != null) q.add(root.left);
	                    if(root.right != null) q.add(root.right);
	                }
	                if(reverseLevel) Collections.reverse(level);
	                result.add(level);
	                reverseLevel = !reverseLevel;
	            }

	            return result;
	        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
