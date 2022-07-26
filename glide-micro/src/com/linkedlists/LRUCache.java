package com.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	class  Node{
        Node prev;
        Node next;
        int val;
        int key;
        
        Node(int key , int val){
            this.val = val;
            this.key = key;
        }
    }
    Map<Integer , Node> map  = new HashMap<>();;
    int capacity=0;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        head = new Node(0 , 0);
       tail = new Node(0,0);
        head.next=tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
       Node node = map.get(key);
        
        if(node == null)
            return -1;
        
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
            remove(map.get(key));
        
        if(map.size() == capacity)
            remove(tail.prev);
        
        insert(new Node(key , value));
        
    }
    
    public void insert(Node node){
        map.put(node.key , node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        
    }
    
    public void remove(Node n){
         n.prev.next=n.next;
          n.next.prev = n.prev;
        map.remove(n.key);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
