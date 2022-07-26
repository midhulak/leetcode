package com.snc.affirm;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlattenList {
	
	
	
	public static List<Integer> flattenList(List<List<Integer>> list){
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(List<Integer> innList : list) {
			
			for(int l : innList) {
				result.add(l);
			}
		}
		
		return result;
		
	}
	
	
	public static List<Integer> flattenListRecurse(List<List<Integer>> list , int index , List<Integer> result){
		
		if(index == list.size())
			return result;
		
		
		for(int l : list.get(index)) {
			
			result.add(l);
		}
		
		return flattenListRecurse(list , index+1 , result);
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> list = new ArrayList<>();
		
	List<Integer> list1 = new ArrayList<>();
	
	list1.add(1);
	List<Integer> list2 = new ArrayList<>();
	list2.add(2);
	list2.add(3);
	List<Integer> list3 = new ArrayList<>();
	
		list3.add(4);
		
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		//flattenList(list);
		System.out.println(flattenListRecurse(list , 0 , new LinkedList<Integer>()));

	}

}
