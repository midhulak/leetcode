package com.snc.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort4 {

public static List<Integer> merge_sort(List<Integer> arr) {
        
        // Write your code here
        
        if(arr.size() > 1){
      
        
      
        
        List<Integer> leftHalf = new ArrayList<Integer>();
        List<Integer> rightHalf = new ArrayList<Integer>();
        
        for(int i=0 ; i<arr.size()/2 ; i++){
            leftHalf.add(arr.get(i));
        }
        
          for(int j=arr.size()/2  ; j<arr.size() ; j++){
            rightHalf.add(arr.get(j));
        }
        
        if(leftHalf.size() != 0)
            {
                merge_sort(leftHalf);
                merge_sort(rightHalf);
            }
            int i=0;
            int j=0;
            int k=0;
            
             while(i<leftHalf.size() && j<rightHalf.size()){
              
              if(leftHalf.get(i) <= rightHalf.get(i)){
                  
                  arr.set(k,leftHalf.get(i));
                  i++;
                  k++;
              }
              else{
                  arr.set(k,rightHalf.get(j));
                  j++;
                  k++;
              }
              
          }
          
          while(i<leftHalf.size()){
              arr.set(k,leftHalf.get(i));
              i++;
              k++;
          }
          
           while(j<rightHalf.size()){
              arr.set(k,rightHalf.get(j));
              j++;
              k++;
          }
        
        
     
        

    }
      return  arr;
    }


public static void main(String[] args) {
	
	List<Integer> arr = new ArrayList<Integer>();

	
	arr.add(7);
	arr.add(1);
	arr.add(3);
	arr.add(5);
	arr.add(7);
    arr.add(-2);
	arr.add(-4);
	arr.add(-6);
	
	
	List<Integer> result = merge_sort(arr);
	
	for(int i=0 ; i<result.size(); i++) {
		System.out.println(result.get(i)+",");
	}
}

}
