package com.snc.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	 
	   class ListNode{
	       ListNode prev;
	       ListNode next;
	       int value;
	       int key;
	       
	       ListNode(int key , int val){
	           this.key = key;
	           this.value = val;
	       }
	        
	    }
	    Map<Integer , ListNode> map = new HashMap<>();
	     ListNode head;
	     ListNode last;
	    
	    
	     int capacity=0;

	    public LRUCache(int capacity) {
	        
	        head = new ListNode(0,0);
	         last = new ListNode(0,0);
	        
	        head.next = last;
	        last.prev=head;
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        
	        ListNode node = map.get(key);
	        
	        if(node == null)
	            return -1;
	        
	        remove(node);
	        insert(node);
	        return node.value;
	        
	    }
	    
	    public void put(int key, int value) {
	        
	        if(map.containsKey(key))
	            remove(map.get(key));
	        
	        if(map.size() == capacity)
	          remove(last.prev);
	        
	        insert(new ListNode(key , value));
	    }
	    
	    public void remove(ListNode node){
	        
	        map.remove(node.key);
	        //1 2 3
	        
	        node.prev.next = node.next;
	        node.next.prev= node.prev;
	    }
	    
	    public void insert(ListNode node){
	        
	         map.put(node.key , node);
		        node.next = head.next;
		        head.next.prev = node;
		        node.prev = head;
		        head.next = node;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
