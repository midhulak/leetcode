package com.snc.leetcodechallenges.feb;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator  implements Iterator<Integer> {
	
	// Java Iterator interface reference:
	// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	    
	     Iterator<Integer> iter;
	     Integer peekedValue = null;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		  iter = iterator;
	        
		}
		
	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        
	        if(peekedValue == null){
	       if(!iter.hasNext())
	           throw new NoSuchElementException();
	            
	            peekedValue = iter.next();
	            
	        }
	        return peekedValue;
	        
		}
		
		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    if(peekedValue != null){
	         int temp = peekedValue;
	         peekedValue=null;
	         return temp;
	        }
	       
	    if(!iter.hasNext())
	        throw new NoSuchElementException();
	        
	        return iter.next();
	    }
		
		@Override
		public boolean hasNext() {
		    
	        return peekedValue != null || iter.hasNext();
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
