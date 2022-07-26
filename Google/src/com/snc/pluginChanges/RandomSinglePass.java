package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSinglePass {
	
	public static ArrayList<String> sample(ArrayList<String> items , int n){
		Random random = new Random();
		ArrayList<String> result = new ArrayList<>();
		for(int i=0 ; i < items.size(); i++) {
			if(i < n) {
				result.add(items.get(i));
			}
			else {
				int j = random.nextInt(i+1);
				
				if(j < n)
					result.set(j,items.get(i));
			}
		}
		return result;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  List<String> list = new ArrayList<String>();
   list.add("apple1");
   list.add("apple2");
   list.add("apple3");
   list.add("apple4");
   list.add("apple5");
   list.add("apple6");
   list.add("apple7");
   
   ArrayList<String> result34 = sample((ArrayList<String>) list , 5);
   
   for(int i=0 ; i<result34.size(); i++) {
	   
	   System.out.println(result34.get(i));
   }

	}

}
