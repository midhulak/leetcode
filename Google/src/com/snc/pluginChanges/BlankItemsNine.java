package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BlankItemsNine {
	
	static Consumer<List<String>> deleteBlankItems = (items) -> {
		
		for(int i=0; i < items.size(); i++) {
			if(items.get(i).length() == 0) {
				items.remove(i);
			}
		}
		
	};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<>(Arrays.asList("Rachel" , "Meghana" , "", "" , "Tim"));
	 deleteBlankItems.accept(names);

	}

}
