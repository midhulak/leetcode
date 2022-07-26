package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodApplyFifteen {
	
	public static List<Integer> map(List<Integer> array, Function<Integer , Integer> method){
		
		List<Integer> result = new ArrayList<>();
		
		for(int element : array) {
			int value = method.apply(element);
			//System.out.println(value);
			result.add(value);
		}
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(7);
		
		Function<Integer , Integer> f1 = i -> i*2;
		
		List<Integer> res = map(list , f1);
		for(int i=0 ; i< res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

}
