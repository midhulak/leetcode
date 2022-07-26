package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFourteen {
	
	public static void example(Predicate<Integer> func , ArrayList<Integer> items) {
		
		int i=0;
		
		for(int item : items) {
			if(func.test(item)) {
				items.set(i, item);
				i+=1;
			}
		}
		items.subList(i,  items.size()).clear();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Predicate<Integer> func =  i -> (i < 10);
		
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	list.add(4);
	list.add(8);
	list.add(10);
	list.add(19);
	list.add(20);
	list.add(3);
	
	example(func , list);

	}

}
