import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

// get and put in O(1) time complexity?
//Space complexity : \mathcal{O}(capacity)O(capacity) since the space
//is used only for an ordered dictionary with at most capacity + 1 elements.
//doubly linked list
public class LRUCache {
	
	  class Node{
	        int key;
	        int value;
	        Node prev;
	        Node next;
	        
	        Node(int k , int v){
	            key = k;
	            value = v;
	        }
	    }
	    
	    private Map<Integer , Node> map = new HashMap<>();
	    private Node head;
	    private Node last;
	    private int capacity;
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        head = new Node(0,0);
	        last = new Node(0,0);
	        head.next = last;
	        last.prev = head;
	    }
	    
	    public int get(int key) {
	        Node node = map.get(key);
	        
	        if(node == null){
	            return -1;
	        }
	        
	        remove(node);
	        insert(node);
	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	        
	        if(map.containsKey(key)){
	            remove(map.get(key));
	        }
	        
	        if(map.size() == capacity){
	            remove(last.prev);
	        }
	        insert(new Node(key , value));
	        
	    }
	    
	    private void insert(Node node){
	    	//first put in map
	         map.put(node.key , node);
	        node.next = head.next;
	        head.next.prev = node;
	        node.prev = head;
	        head.next = node;
	    }
	    
	    private void remove(Node node){
	        map.remove(node.key);
	        //try to update links from doubly linked list
	            node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}