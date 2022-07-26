package com.snc.Arrays;

import java.util.ArrayList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 
 * @author midhula.kadiyala
 *
 */

public class MovingAverageFromDataStream {
	
	
		  
	    /** Initialize your data structure here. */
	    int size=0;
	    ArrayList<Integer> list ;
	    public MovingAverageFromDataStream(int size) {
	         list = new ArrayList<Integer>();
	        this.size=size;
	    }
	    
	    public double next(int val) {
	        list.add(val);
	        int count=0;
	        double sum=0.0;
	        if(list.size() <= size){
	            
	            for(Integer item : list){
	                sum=sum+item;
	               
	            }
	            
	            return sum/list.size();
	        }
	        
	        else{
	            
	            
	            for(int i=list.size()-1; i>=0 ; i--){
	                if(count == size)
	                        break;
	                sum=sum+list.get(i);
	                count++;
	            }
	               return sum/size;
	            }
	            
	        
	        }
	        
	       
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
