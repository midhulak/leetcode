import java.util.HashSet;
import java.util.Set;

/*
 * Time complexity : in both serialization and deserialization functions, we visit each node exactly once, thus the time complexity is O(N)O(N), where NN is the number of nodes, i.e. the size of tree.

Space complexity : in both serialization and deserialization functions, we keep the entire tree, either at the beginning or at the end, therefore, the space complexity is O(N)O(N).
 */

public class SerializeBinaryTree {

	

	    public static class TreeNode {
	        int val;
	        TreeNode left;
	        TreeNode right;
	        TreeNode(int x) { val = x; }
	    }

	    public static class Codec {
	        private static final char delimeter = ' ';
	        private static final String nullStr = "N";

	        // Encodes a tree to a single string.
	        public static String serialize(TreeNode root) {
	            if (root == null) return "";
	            StringBuffer sb = new StringBuffer();
	            serialize(root, sb);

	            // remove trailing nulls
	            int i = sb.length() - 2;
	            while (sb.charAt(i) == 'N') i -= 2;
	            return sb.delete(i + 1, sb.length()).toString().trim();
	        }

	        private static void serialize(TreeNode root, StringBuffer sb) {
	            if (root == null) {
	                sb.append(nullStr);
	                sb.append(delimeter);
	            } else {
	                sb.append(root.val);
	                sb.append(delimeter);
	                serialize(root.left, sb);
	                serialize(root.right, sb);
	            }
	        }

	        // Decodes your encoded data to tree.
	        public static TreeNode deserialize(String data) {
	            if (data == null || data.trim().isEmpty()) return null;
	            String[] nodes = data.split(" ");
	            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
	            deserialize(nodes, root, new int[1]);
	            return root;
	        }

	        private static void deserialize(String[] nodes, TreeNode root, int[] i) {
	            if (i[0] >= nodes.length || nullStr.equals(nodes[i[0]])) return;
	            if (i[0] + 1 < nodes.length) {
	                root.left = nullStr.equals(nodes[i[0] + 1]) ? null : new TreeNode(Integer.parseInt(nodes[i[0] + 1]));
	                i[0]++;
	                deserialize(nodes, root.left, i);
	            }

	            if (i[0] + 1 < nodes.length) {
	                root.right = nullStr.equals(nodes[i[0] + 1]) ? null : new TreeNode(Integer.parseInt(nodes[i[0] + 1]));
	                i[0]++;
	                deserialize(nodes, root.right, i);
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	
	    	Set<String> set = new HashSet<String>();
	    	set.add("abc");
	    	set.add("def");
	    	set.add("ghi");
	    	
	   
	    	
	        Codec codec = new Codec();

	        TreeNode tree = new TreeNode(1);
	        tree.left = new TreeNode(2);
	        tree.right = new TreeNode(3);
	        tree.left.left = new TreeNode(4);
	       // tree.left.right = new TreeNode(5);
	        
	        String serialized = codec.serialize(tree);
	        System.out.println("serialized="+serialized);
	        
	        TreeNode newTree = codec.deserialize(serialized);
	        System.out.println(newTree.val);
	        System.out.println(newTree.left.val);
	        System.out.println(newTree.right.val);
	//
//	        System.out.println("Passed all test cases");
	    
	    }
}


