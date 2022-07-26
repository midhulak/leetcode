package com.snc.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	 public static List<Integer> merge_sort(List<Integer> arr) {
	        
	        // Write your code here
	        
	        if(arr.size() <= 1)
	        return arr;
	        
	        List<Integer> leftHalf = new ArrayList<Integer>();
	        List<Integer> rightHalf = new ArrayList<Integer>();
	        
	        for(int i=0 ; i<arr.size()/2 ; i++){
	            leftHalf.add(arr.get(i));
	        }
	        
	          for(int j=arr.size()/2  ; j<arr.size() ; j++){
	            rightHalf.add(arr.get(j));
	        }
	        
	       return  mergeSortHelper(merge_sort(leftHalf) , merge_sort(rightHalf));
	        

	    }
	    
	    
	    public static List<Integer> mergeSortHelper(List<Integer> leftHalf , List<Integer> rightHalf){
	        
	        List<Integer> sortArray = new ArrayList<Integer>();
	        
	          int i=0;
	          int j=0;
	         
	          
	          while(i<leftHalf.size() && j<rightHalf.size()){
	              
	              if(leftHalf.get(i) <= rightHalf.get(j)){
	                  
	                  sortArray.add(leftHalf.get(i));
	                  i++;
	              }
	              else{
	                  sortArray.add(rightHalf.get(j));
	                  j++;
	              }
	              
	          }
	          
	          while(i<leftHalf.size()){
	              sortArray.add(i);
	              i++;
	          }
	          
	           while(j<rightHalf.size()){
	              sortArray.add(j);
	              j++;
	          }
	        
	        return sortArray;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(4);
		arr.add(0);
		arr.add(1);
		arr.add(3);
		arr.add(2);
		
		List<Integer> result = merge_sort(arr);
		
		for(int i=0 ; i<result.size(); i++) {
			
			System.out.println("result is="+result.get(i));
		}
	}

}
