package com.snc.onsite.set1;

import java.util.ArrayList;

public class ExamRoom {
	
	 ArrayList<Integer> list;
	    int n;
	   
	    public ExamRoom(int n) {
	    	list = new ArrayList<>();
	        this.n = n;
	    }
	    
	    public int seat() {
	        
	    	 if(list.size() == 0){
	             list.add(0);
	             return 0;
	         }
	          
	          int  distance =Math.max(list.get(0)- 0 , n-1-list.get(list.size() - 1));
	          for(int i=0; i<list.size()-1; i++){
	              distance = Math.max(distance , (list.get(i+1) - list.get(i))/2);
	          }
	          
	          if(list.get(0) == distance){
	              list.add(0,0);
	              return 0;
	          }
	          
	          for(int i=0; i < list.size() - 1; i++){
	              int currDistance = (list.get(i+1) - list.get(i))/2;
	              
	              if(currDistance == distance){
	                  list.add(i+1 , (list.get(i+1) + list.get(i))/2);
	                  return list.get(i+1);
	              }
	          }
	             list.add(n-1);
	             return n - 1;
	        
	    }
	    
	    public boolean leave(int p) {
	    	 for(int i=0; i<list.size(); i++){
	             
	             if(list.get(i) == p){
	                 list.remove(i);
	                 return true;
	             }
	         }
	    	 return false;
	    }
	    
	    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExamRoom e = new ExamRoom(10);
		
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.leave(0));
		System.out.println(e.leave(4));
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.leave(0));
		
		
	}

}
