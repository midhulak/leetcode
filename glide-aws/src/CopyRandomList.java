import java.util.HashMap;
import java.util.Map;

/*
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
/**
 * Time Complexity : O(N)O(N) because we make one pass over the original linked list.
Space Complexity : O(N)O(N) as we have a dictionary containing mapping from old list nodes to new list nodes. Since there are NN nodes, we have O(N)O(N) space complexity.

 * @author midhula.kadiyala
 *
 */
public class CopyRandomList {
	
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public static  Node copyRandomList(Node n) {
        if (n == null) return n;
        
        Map<Node , Node> nodeMap = new HashMap<>();
        Node currentNode = n;
        //first iterate teh whole list and add nodes to teh map
        while(currentNode != null){
            nodeMap.put(currentNode , new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        
        //Fix next and random pointers again iterate from head and get head from map and point head .next in map.get(head).next = map.get(head.next) and same as random
        currentNode = n;
        
        while(currentNode != null){
            nodeMap.get(currentNode).next = currentNode.next != null ? nodeMap.get(currentNode.next) : null;
            
            nodeMap.get(currentNode).random = currentNode.random != null ? nodeMap.get(currentNode.random) : null;
            currentNode = currentNode.next;
        }
        
       return nodeMap.get(n);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
