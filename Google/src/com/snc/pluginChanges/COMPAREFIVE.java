package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class COMPAREFIVE {
	
	static <T extends Comparable<? super T>> T select(List<T> values ,int k) {
		
		Random random = new Random();
		
		int r = random.nextInt(values.size());
		
		T pivot = values.get(r);
		
		List<T> low = new ArrayList<T>();
		List<T> high = new ArrayList<T>();
		
		for(T value : values) {
			if(value.compareTo(pivot) < 0)
				low.add(value);
			
			else if(value.compareTo(pivot) > 0) {
				high.add(value);
			}
		}
		if(k < low.size())
			return select(low,k);
		//k-=low.size(); //illegal arg
		//k-=values.size(); //not exact o/p
		//k=values.size()-high.size()-low.size(); //illegal arg
		k+=high.size() - values.size(); //not exact o/p
		
		if(k < 0) {
			return pivot;
		}
		
		return select(high , k);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(-1);
		list.add(-2);
		
		//21,9,1,
		System.out.println(select(list,3));
		
	}

}
