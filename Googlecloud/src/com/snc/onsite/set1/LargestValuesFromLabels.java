package com.snc.onsite.set1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//given two sets of interger arrays and have to get max length of some size havee to choose the labels (once or twice based on input useLimit)

public class LargestValuesFromLabels {
	
	  public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
	        
	        class Item{
	            int label;
	            int value;
	            
	            public Item(int value , int label){
	                this.label = label;
	                this.value = value;
	            }
	        }
	        
	    List<Item> items = new ArrayList<>();
	        
	        for(int i=0; i< values.length; i++){
	            items.add(new Item(values[i] , labels[i]));
	        }
	        
	        PriorityQueue<Item> pq = new PriorityQueue<>( (Item a , Item b) -> b.value - a.value); //sorting it based on value sin descending order
	        pq.addAll(items);
	        
	        int result=0;
	        Map<Integer , Integer> map = new HashMap<>();
	        //we can stop this when we reach the numWanted count to 0
	        while(!pq.isEmpty() && numWanted > 0){
	            //removing 1 item at a time
	            Item itm = pq.remove();
	            //putting the label in map to track how many times the label has been used
	              map.put(itm.label , map.getOrDefault(itm.label , 0)+1);
	            //if label used less than uselimit we can use that value other wise we can continur
	            if( map.get(itm.label)<= useLimit){
	                result+=itm.value;
	                numWanted--;
	             }
	           
	        }
	         return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
