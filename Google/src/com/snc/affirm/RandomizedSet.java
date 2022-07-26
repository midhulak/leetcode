package com.snc.affirm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	  List<Integer> list;
    Map<Integer , Integer> map;
    Random rand ;
 

    /** Initialize your data structure here. */
    public RandomizedSet() {
         map = new HashMap<>();
        list = new ArrayList<>();
   
        
        rand=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
       
        if(!map.containsKey(val)){
           
            map.put(val , list.size());
            list.add(list.size() , val);
          
            return true;
        }
       
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
            System.out.println("trying to remove value="+val);
        if(!map.containsKey(val))
            return false;
     
        int index = map.get(val);
        int lastEle = list.get(list.size()-1);
        
        list.set(index , lastEle);
        map.put(lastEle , index);
        list.remove(list.size() - 1);
        System.out.println("list size="+list.size());
        map.remove(val);
       
        return true;
     
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
       
       if(list.size() == 1)
           return list.get(0);
        
    int val = rand.nextInt(list.size()-1);
        
       return list.get(val);
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet r = new RandomizedSet();
		System.out.println(r.insert(0));
		System.out.println(r.insert(1));
		System.out.println(r.remove(0));
		System.out.println(r.insert(2));
		System.out.println(r.remove(1));
		System.out.println(r.getRandom());

	}

}
